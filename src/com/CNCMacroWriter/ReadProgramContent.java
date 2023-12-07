package com.CNCMacroWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.Stack;

public class ReadProgramContent {
    private boolean statusMacros;
    private boolean g10Logic;
    private boolean engravingSplit;

    // private static ArrayList<Integer> sisterToolList = new ArrayList<>();
    // private static int engravingTool = 13;
    private static int partCounter = 1;
    private static String engravingLogic = "#825=#825+1\n";

    private static String returnData = "";
    private static boolean toolEndDetected;
    private static int finishedTool;
    private static int nextTool;

    private static int stageCounter = 0;
    private static int lineCounter = 0;

    private static String endDector = "G130";
    private static String M01 = "M01";
    private static String M06 = "M06";
    private static String M30 = "M30";
    private static String progStart = "M98<TIMER_RESET>";

    private String programmer;
    private String workOrder;
    private String operationNumber;

    private String xCord ;
    private String yCord ;
    private String zCord ;
    private String bCord ;

    private static Stack<Integer> toolStack = new Stack<Integer>();

    public void getContent(final String fileName) {
        Path path = Paths.get(fileName);
        String fileLine;

        try (Scanner fileData = new Scanner(path)) {
            while (fileData.hasNextLine()) {
                fileLine = fileData.nextLine();
                ++lineCounter;

                String g10Line ="";
                if (g10Logic) {
                    g10Line=String.format("\n\n\nG10 G90 L2 P1 X-%s Y-%s Z-%s B90.0 ", this.xCord,this.yCord,this.zCord,this.bCord);
                }


                // watch for Cycle End
                if (fileLine.contains(endDector)) {
                    toolEndDetected = true;
                } else if (!fileLine.isEmpty() && fileLine.charAt(0) == 'T') {
                    // Extracting the active tool from the 'fileLine' string:
                    // Skip the first character of the 'fileLine' string,Split the substring based
                    // on spaces, resulting in an array of substrings,Access the first element of
                    // the array, which contains the active tool name
                    String extractActiveTool = fileLine.substring(1).split(" ")[0];
                    toolStack.push(Integer.parseInt(extractActiveTool));
                    nextTool = Integer.parseInt(extractActiveTool);

                }

                

                if (statusMacros && toolEndDetected && (fileLine.contains(M01) || fileLine.contains(M30))) {
                    ++stageCounter;

                    String endOfProgram = "";
                    if (fileLine.contains(M30)) {
                        endOfProgram = "(END OF PROGRAM)\n#849=99\n";
                        fileLine="M#850";
                    }
                    returnData += String.format(
                            "#840 = %d(FINISHED TOOL)\n#841 = %d(ACTIVE TOOL)\n#842 = %d(STAGE NUMBER)\n#843 = %d(COMPLETED)\n%sM98<DATA_COLLECT>\n",
                            finishedTool, nextTool, stageCounter, lineCounter, endOfProgram);
                    toolEndDetected = false;
                } else if (fileLine.contains(M06)) {
                    finishedTool = toolStack.pop();
                } else if (statusMacros && fileLine.contains(progStart)) {
                    returnData += String.format("#826=%s\n#827=%s\n#828=%s\n#829=0\n#830 = var1 \n#831= var2 \n",
                            this.workOrder, this.operationNumber, this.programmer)+g10Line;
                } else {
                    if (engravingSplit) {
                        if (fileLine.contains("ENGRAVINGCHECK")) {
                            returnData += "ADDENGRAVINGLOGICHERE";
                            fileLine = "";
                        } else if (fileLine.contains("PART" + String.valueOf(partCounter))) {
                            if (partCounter == 1) {
                                returnData += "N10" + String.valueOf(partCounter);
                            } else {
                                returnData += "GOTO999 \nN10" + String.valueOf(partCounter);
                            }
                            engravingLogic += String.format("IF[#825EQ%d]GOTO10%d\n", partCounter, partCounter);
                            ++partCounter;
                        } else if (fileLine.contains("ENGRAVINGEND")) {
                            returnData += "N999\n";

                        }
                    }
                }

                returnData += fileLine + "\n";
            }
            returnData = returnData.replace("ADDENGRAVINGLOGICHERE", engravingLogic);
            returnData = returnData.replaceFirst("var1", String.valueOf(stageCounter));
            returnData = returnData.replaceFirst("var2", String.valueOf(lineCounter));
            fileData.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        postCode(returnData);
    }

    public static void postCode(final String code) {
        try {
            FileWriter write = new FileWriter("_Macro");
            write.write(code);
            write.close();
        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public void setStatusMacro(final Boolean value) {
        this.statusMacros = value;
    }

    public void setG10Macro(final boolean value) {
        this.g10Logic = value;
    }

    public void setProgramer(final String programmer) {
        this.programmer = programmer;
    }

    public void setWorkOrder(final String workOrder) {
        this.workOrder = workOrder;
    }

    public void setOperationNumber(final String operationNumber) {
        this.operationNumber = operationNumber;
    }

    public void setEngraving(final boolean value) {
        this.engravingSplit = value;
    }

    public void setXCord(final String value) {
        this.xCord = value;
    }

    public void setYCord(final String value) {
        this.yCord = value;
    }

    public void setZCord(final String value) {
        this.zCord = value;
    }

    public void setBCord(final String value) {
        this.bCord = value;
    }
}
