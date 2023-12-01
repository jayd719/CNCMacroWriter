package com.CNCMacroWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.Stack;

public class ReadProgramContent {
    private static boolean statusMacros = true;
    private static boolean g10Logic = true;
    private static boolean engravingSplit = true;

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

    private static Stack<Integer> toolStack = new Stack<Integer>();

    public static void getContent(final String fileName) {
        Path path = Paths.get(fileName);

        try (Scanner fileData = new Scanner(path)) {
            while (fileData.hasNextLine()) {
                String fileLine = fileData.nextLine();
                ++lineCounter;
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

                if(g10Logic){
                    //TODO add logi
                }

                if (statusMacros && toolEndDetected && (fileLine.contains(M01) || fileLine.contains(M30))) {
                    ++stageCounter;

                    String endOfProgram = "";
                    if (fileLine.contains(M30)) {
                        endOfProgram = "(END OF PROGRAM)\n#840=99\n";
                    }
                    returnData += String.format(
                            "#840 = %d(FINISHED TOOL)\n#841 = %d(ACTIVE TOOL)\n#842 = %d(STAGE NUMBER)\n#843 = %d(COMPLETED)\n%sM98<DATA_COLLECT>\n",
                            finishedTool, nextTool, stageCounter, lineCounter, endOfProgram);
                    toolEndDetected = false;
                } else if (fileLine.contains(M06)) {
                    finishedTool = toolStack.pop();
                } else if (statusMacros && fileLine.contains(progStart)) {
                    returnData += "#840=0\n#849=0\n#850 = var1 \n#851= var2 \n";
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
        ReadProgramContent.statusMacros = value;
    }

    public void setG10Macro(final boolean value){
        ReadProgramContent.g10Logic= value;
    }

}
