
import java.util.ArrayList;
import java.util.Random;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;


/**
 *
 * @author Jacek Byzdra
 * email: jacekbwwa@gmail.com
 */
public class Model {

    protected Player player1 = new Player();
    protected Player comp = new Player();
    protected Player player2 = new Player();
    protected Cell cell = new Cell();
    protected Cell[][] CellArr = new Cell[3][3];

    protected ToggleGroup groupPlayer1Signs = new ToggleGroup();
    protected ToggleGroup groupPlayer2Signs = new ToggleGroup();
    protected ToggleGroup groupCompSign = new ToggleGroup();
    protected ToggleGroup groupPlayer1 = new ToggleGroup();
    protected ToggleGroup groupPlayer2 = new ToggleGroup();
    protected ToggleGroup groupComp = new ToggleGroup();

    private String playerName;
    private int fireRowXComp;
    private int fireColYComp;
    protected int fireRowXMouseBut;
    protected int fireColYMouseBut;
    private String returnPlayerSign;
    protected int fireRowISign;
    protected int fireColJSign;
    private String fireSign;
    private Pair pairXYArr;
    private Pair pair;
    private ArrayList<Pair> tempArrList;
    private int sumWeightsRow0;
    private int sumWeightsRow1;
    private int sumWeightsRow2;
    private int sumWeightsCol0;
    private int sumWeightsCol1;
    private int sumWeightsCol2;
    private int sumWeightsDiagf;
    private int sumWeightsDiagb;
    private int sumPlayersRow0;
    private int sumPlayersRow1;
    private int sumPlayersRow2;
    private int sumPlayersCol0;
    private int sumPlayersCol1;
    private int sumPlayersCol2;
    private int sumPlayersDiagF;
    private int sumPlayersDiagB;
    protected int sumWinPlayer1;
    protected int sumWinPlayer2;
    protected int sumWinComp;
    protected boolean winPlayer1;
    protected boolean winPlayer2;
    protected boolean winComp;
    private int int1;
    private int int2;

    public Model() {
        cell = new Cell();
        CellArr = new Cell[3][3];
        tempArrList = new ArrayList();
        pairXYArr = new Pair(int1, int2);
        pair = new Pair();

    }

    public void addCellAndNameToCellArr() {
        CellArr = new Cell[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cell = new Cell();
                CellArr[i][j] = cell;
                CellArr[i][j].setCellName("c" + i + j);
            }
        }
    }

    public void addPairToCellArr() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                pair = new Pair(i, j);
                CellArr[i][j].setPair(pair);
                CellArr[i][j].getPair().setInt1(i);
                CellArr[i][j].getPair().setInt2(j);

            }
        }

    }

    public boolean checkIfPlayersArrayIsFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if ("N".equals(CellArr[i][j].getCellState())) {
                    return false;
                }
            }

        }
        return true;
    }

    public void addNtoCellsStatePlayersArray() {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                if (CellArr[i][j] == null) {
                    CellArr[i][j].setCellState("N");
                }
            }
        }
    }

    public void addNtoCellSignArr() {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                if (CellArr[i][j].getCellState() == null) {
                    CellArr[i][j].setCellState("N");
                }
            }
        }
    }

    public void addPlayerNametoCellState(String playerName, int i, int j) {

        for (int v = 0; v < 3; v++) {
            for (int y = 0; y < 3; y++) {
                if ((v == i) && (y == j)) {

                    CellArr[i][j].setCellState(playerName);
                }
            }

        }

    }

    public void addWeightNumPlayerToCell(int v, int y) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if ((i == v) && (j == y) && (null != CellArr[i][j])) {
                    switch (CellArr[i][j].getCellState()) {
                        case "N":
                            CellArr[i][j].setWeightNumberPlayers(0);

                        case "PL1TAKEN":
                            CellArr[i][j].setWeightNumberPlayers(5);

                            break;
                        case "PL2TAKEN":
                            CellArr[i][j].setWeightNumberPlayers(20);

                            break;
                        case "COMPTAKEN":
                            CellArr[i][j].setWeightNumberPlayers(100);

                            break;
                        default:
                            break;
                    }

                }

            }
        }

    }

    public void addWeightsNumbersPlayersToCell() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (null != CellArr[i][j]) {
                    switch (CellArr[i][j].getCellState()) {
                        case "N":
                            CellArr[i][j].setWeightNumberPlayers(0);
                            break;
                        case "PL1TAKEN":
                            CellArr[i][j].setWeightNumberPlayers(5);

                            break;
                        case "PL2TAKEN":
                            CellArr[i][j].setWeightNumberPlayers(20);

                            break;
                        case "COMPTAKEN":
                            CellArr[i][j].setWeightNumberPlayers(100);

                            break;
                        default:
                            break;
                    }

                }

            }
        }

    }

    public String getCellStateFromArr(int a, int b) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == a && j == b) {
                    playerName = CellArr[a][b].getCellState();
                }
            }
        }
        return playerName;
    }

    public void printCellsState() {
        for (int j = 0; j < 3; j++) {
            int i = 0;
            System.out.print(i + "" + j + " " + CellArr[i][j].getCellState() + " , ");
        }
        System.out.println("\n");

        for (int j = 0; j < 3; j++) {
            int i = 1;
            System.out.print(i + "" + j + " " + CellArr[i][j].getCellState() + " , ");
        }
        System.out.println("\n");

        for (int j = 0; j < 3; j++) {
            int i = 2;
            System.out.print(i + "" + j + " " + CellArr[i][j].getCellState() + " , ");
        }
        System.out.println("\n");

    }

    public void makeSpaceVirtual() {
        System.out.println();
        System.out.println();
    }

    public void printSumWeights() {
        System.out.println("  sumWeightsRow0 = " + sumWeightsRow0 + " ");
        System.out.println("  sumWeightsRow1 = " + sumWeightsRow1 + " ");
        System.out.println("  sumWeightsRow2 = " + sumWeightsRow2 + " ");
        System.out.println("  sumWeightsCol0 = " + sumWeightsCol0 + " ");
        System.out.println("  sumWeightsCol1 = " + sumWeightsCol1 + " ");
        System.out.println("  sumWeightsCol2 = " + sumWeightsCol2 + " ");
        System.out.println("  sumWeightsDiagf = " + sumWeightsDiagf + " ");
        System.out.println("  sumWeightsDiagb = " + sumWeightsDiagb + " ");

    }

    public void printSumPlayers() {
        System.out.println(" sumPlayersRow0 = " + sumPlayersRow0);
        System.out.println(" sumPlayersRow1 = " + sumPlayersRow1);
        System.out.println(" sumPlayersRow2 = " + sumPlayersRow2);
        System.out.println(" sumPlayersCol0 = " + sumPlayersCol0);
        System.out.println(" sumPlayersCol1 = " + sumPlayersCol1);
        System.out.println(" sumPlayersCol2 = " + sumPlayersCol2);
        System.out.println(" sumPlayersDiagF = " + sumPlayersDiagF);
        System.out.println(" sumPlayersDiagB = " + sumPlayersDiagB);
    }

    public void printCellsName() {
        for (int a = 0; a < 3; a++) {
            for (int b = 0; b < 3; b++) {
                System.out.print(CellArr[a][b].getCellName());
            }
            System.out.println();
        }
    }

    public int getXPriorCellsComp() {
        int x = 5;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (CellArr[i][j].getPriorCellsComp() == 1000) {
                    x = CellArr[i][j].getPair().getInt1();
                    return x;
                } else if (CellArr[i][j].getPriorCellsComp() == 900) {
                    x = CellArr[i][j].getPair().getInt1();
                    return x;
                } else if (CellArr[i][j].getPriorCellsComp() == 800) {
                    x = CellArr[i][j].getPair().getInt1();
                    return x;
                } else if (CellArr[i][j].getPriorCellsComp() == 700) {
                    x = CellArr[i][j].getPair().getInt1();
                    return x;
                }

            }
        }
        return x;
    }

    public int getYPriorCellsComp() {
        int y = 5;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (CellArr[i][j].getPriorCellsComp() == 1000) {
                    y = CellArr[i][j].getPair().getInt2();
                    return y;
                } else if (CellArr[i][j].getPriorCellsComp() == 900) {
                    y = CellArr[i][j].getPair().getInt2();
                    return y;
                } else if (CellArr[i][j].getPriorCellsComp() == 800) {
                    y = CellArr[i][j].getPair().getInt2();
                    return y;
                } else if (CellArr[i][j].getPriorCellsComp() == 700) {
                    y = CellArr[i][j].getPair().getInt2();
                    return y;
                }
            }
        }
        return y;
    }

    public int getXPriorCellsPlayer1() {
        int x = 5;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (CellArr[i][j].getPriorCellsPlayer1() == 1000) {
                    x = CellArr[i][j].getPair().getInt1();
                    return x;
                } else if (CellArr[i][j].getPriorCellsPlayer1() == 900) {
                    x = CellArr[i][j].getPair().getInt1();
                    return x;
                } else if (CellArr[i][j].getPriorCellsPlayer1() == 800) {
                    x = CellArr[i][j].getPair().getInt1();
                    return x;
                } else if (CellArr[i][j].getPriorCellsPlayer1() == 700) {
                    x = CellArr[i][j].getPair().getInt1();
                    return x;
                }

            }
        }
        return x;
    }

    public int getYPriorCellsPlayer1() {
        int y = 5;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (CellArr[i][j].getPriorCellsPlayer1() == 1000) {
                    y = CellArr[i][j].getPair().getInt2();
                    return y;
                } else if (CellArr[i][j].getPriorCellsPlayer1() == 900) {
                    y = CellArr[i][j].getPair().getInt2();
                    return y;
                } else if (CellArr[i][j].getPriorCellsPlayer1() == 800) {
                    y = CellArr[i][j].getPair().getInt2();
                    return y;
                } else if (CellArr[i][j].getPriorCellsPlayer1() == 700) {
                    y = CellArr[i][j].getPair().getInt2();
                    return y;
                }

            }
        }
        return y;
    }

    public int getXPriorCellsPlayer2() {
        int x = 5;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (CellArr[i][j].getPriorCellsPlayer2() == 1000) {
                    x = CellArr[i][j].getPair().getInt1();
                    return x;
                } else if (CellArr[i][j].getPriorCellsPlayer2() == 900) {
                    x = CellArr[i][j].getPair().getInt1();
                    return x;
                } else if (CellArr[i][j].getPriorCellsPlayer2() == 800) {
                    x = CellArr[i][j].getPair().getInt1();
                    return x;
                } else if (CellArr[i][j].getPriorCellsPlayer2() == 700) {
                    x = CellArr[i][j].getPair().getInt1();
                    return x;
                }

            }
        }
        return x;
    }

    public int getYPriorCellsPlayer2() {
        int y = 5;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (CellArr[i][j].getPriorCellsPlayer2() == 1000) {
                    y = CellArr[i][j].getPair().getInt2();
                    return y;
                } else if (CellArr[i][j].getPriorCellsPlayer2() == 900) {
                    y = CellArr[i][j].getPair().getInt2();
                    return y;
                } else if (CellArr[i][j].getPriorCellsPlayer2() == 800) {
                    y = CellArr[i][j].getPair().getInt2();
                    return y;
                } else if (CellArr[i][j].getPriorCellsPlayer2() == 700) {
                    y = CellArr[i][j].getPair().getInt2();
                    return y;
                }

            }
        }
        return y;
    }

    public void calcPriorCellsComp() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                CellArr[i][j].setPriorCellsComp(CellArr[i][j].getWeightsMoveComp());
            }
        }

        // sumWeightsRow0 Comp has two cells in row0
        if (sumWeightsRow0 == 1100) {
            for (int j = 0; j < 3; j++) {
                if (CellArr[0][j].getWeightsMoveComp() == 100) {
                    CellArr[0][j].setPriorCellsComp(1000);
                    return;
                }
            }
        } // sumWeightsRow1 Comp has two cells in row1
        else if (sumWeightsRow1 == 1100) {
            for (int j = 0; j < 3; j++) {
                if (CellArr[1][j].getWeightsMoveComp() == 100) {
                    CellArr[1][j].setPriorCellsComp(1000);
                    return;
                }
            }
        } // sumWeightsRow2 Comp has two cells in row2
        else if (sumWeightsRow2 == 1100) {
            for (int j = 0; j < 3; j++) {
                if (CellArr[2][j].getWeightsMoveComp() == 100) {
                    CellArr[2][j].setPriorCellsComp(1000);
                    return;
                }
            }
        } // sumWeightsCol0 Comp has two cells in col0
        else if (sumWeightsCol0 == 1100) {
            for (int i = 0; i < 3; i++) {
                if (CellArr[i][0].getWeightsMoveComp() == 100) {
                    CellArr[i][0].setPriorCellsComp(1000);
                    return;
                }
            }
        } // sumWeightsCol1 Comp has two cells in col1
        else if (sumWeightsCol1 == 1100) {
            for (int i = 0; i < 3; i++) {
                if (CellArr[i][1].getWeightsMoveComp() == 100) {
                    CellArr[i][1].setPriorCellsComp(1000);
                    return;
                }
            }
        } // sumWeightsCol2 Comp has two cells in col2
        else if (sumWeightsCol2 == 1100) {
            for (int i = 0; i < 3; i++) {
                if (CellArr[i][2].getWeightsMoveComp() == 100) {
                    CellArr[i][2].setPriorCellsComp(1000);
                    return;
                }
            }
        } // sumWeightsDiagf Comp has two cells in Diagf
        else if (sumWeightsDiagf == 1100) {
            if (CellArr[0][0].getWeightsMoveComp() == 100) {
                CellArr[0][0].setPriorCellsComp(1000);
                return;
            } else if (CellArr[1][1].getWeightsMoveComp() == 100) {
                CellArr[1][1].setPriorCellsComp(1000);
                return;
            } else if (CellArr[2][2].getWeightsMoveComp() == 100) {
                CellArr[2][2].setPriorCellsComp(1000);
                return;
            }

        } // sumWeightsDiagb Comp has two cells in Diagb
        else if (sumWeightsDiagb == 1100) {
            if (CellArr[0][2].getWeightsMoveComp() == 100) {
                CellArr[0][2].setPriorCellsComp(1000);
                return;
            } else if (CellArr[1][1].getWeightsMoveComp() == 100) {
                CellArr[1][1].setPriorCellsComp(1000);
                return;
            } else if (CellArr[2][0].getWeightsMoveComp() == 100) {
                CellArr[2][0].setPriorCellsComp(1000);
                return;
            }

        } // sumWeightsRow0 Pl1 has two cells in row0
        else if (sumWeightsRow0 == -900) {
            for (int j = 0; j < 3; j++) {
                if (CellArr[0][j].getWeightsMoveComp() == 100) {
                    CellArr[0][j].setPriorCellsComp(900);
                    return;
                }
            }
        } // sumWeightsRow1 PL1 has two cells in row1
        else if (sumWeightsRow1 == -900) {
            for (int j = 0; j < 3; j++) {
                if (CellArr[1][j].getWeightsMoveComp() == 100) {
                    CellArr[1][j].setPriorCellsComp(900);
                    return;
                }
            }
        } // sumWeightsRow2 PL1 has two cells in row2
        else if (sumWeightsRow2 == -900) {
            for (int j = 0; j < 3; j++) {
                if (CellArr[2][j].getWeightsMoveComp() == 100) {
                    CellArr[2][j].setPriorCellsComp(900);
                    return;
                }
            }
        } // sumWeightsCol0 Pl1 has two cells in col0
        else if (sumWeightsCol0 == -900) {
            for (int i = 0; i < 3; i++) {
                if (CellArr[i][0].getWeightsMoveComp() == 100) {
                    CellArr[i][0].setPriorCellsComp(900);
                    return;
                }
            }
        } // sumWeightsCol1 Pl1 has two cells in col1
        else if (sumWeightsCol1 == -900) {
            for (int i = 0; i < 3; i++) {
                if (CellArr[i][1].getWeightsMoveComp() == 100) {
                    CellArr[i][1].setPriorCellsComp(900);
                    return;
                }
            }
        } // sumWeightsCol2 Pl1 has two cells in col2
        else if (sumWeightsCol2 == -900) {
            for (int i = 0; i < 3; i++) {
                if (CellArr[i][2].getWeightsMoveComp() == 100) {
                    CellArr[i][2].setPriorCellsComp(900);
                    return;
                }
            }
        } // sumWeightsDiagf Pl1 has two cells in Diagf
        else if (sumWeightsDiagf == -900) {
            if (CellArr[0][0].getWeightsMoveComp() == 100) {
                CellArr[0][0].setPriorCellsComp(900);
                return;
            } else if (CellArr[1][1].getWeightsMoveComp() == 100) {
                CellArr[1][1].setPriorCellsComp(900);
                return;
            } else if (CellArr[2][2].getWeightsMoveComp() == 100) {
                CellArr[2][2].setPriorCellsComp(900);
                return;
            }

        } // sumWeightsDiagb Pl1 has two cells in Diagb
        else if (sumWeightsDiagb == -900) {
            if (CellArr[0][2].getWeightsMoveComp() == 100) {
                CellArr[0][2].setPriorCellsComp(900);
                return;
            } else if (CellArr[1][1].getWeightsMoveComp() == 100) {
                CellArr[1][1].setPriorCellsComp(900);
                return;
            } else if (CellArr[2][0].getWeightsMoveComp() == 100) {
                CellArr[2][0].setPriorCellsComp(900);
                return;
            }

        } //diagF = 100 and diagB=700
        else if (sumWeightsDiagf == 100 && sumWeightsDiagb == 700) {
            if (CellArr[0][1].getCellState() == "N") {
                CellArr[0][1].setPriorCellsComp(800);
                return;

            } else if (CellArr[1][0].getCellState() == "N") {
                CellArr[1][0].setPriorCellsComp(800);
                return;

            } else if (CellArr[1][2].getCellState() == "N") {
                CellArr[1][2].setPriorCellsComp(800);
                return;

            } else if (CellArr[2][1].getCellState() == "N") {
                CellArr[2][1].setPriorCellsComp(800);
                return;

            }

        } //diagF = 700 and diagB=100
        else if (sumWeightsDiagf == 700 && sumWeightsDiagb == 100) {
            if (CellArr[0][1].getCellState() == "N") {
                CellArr[0][1].setPriorCellsComp(800);
                return;

            } else if (CellArr[1][0].getCellState() == "N") {
                CellArr[1][0].setPriorCellsComp(800);
                return;

            } else if (CellArr[1][2].getCellState() == "N") {
                CellArr[1][2].setPriorCellsComp(800);
                return;

            } else if (CellArr[2][1].getCellState() == "N") {
                CellArr[2][1].setPriorCellsComp(800);
                return;

            }

        } //c00,c11,c22,c20,c02 is free
        else if ((comp.getPlayerQueue() == PlayerQueue.FIRST.toString()) && (CellArr[1][1].getWeightsMoveComp() == 100) && (CellArr[0][0].getWeightsMoveComp() == 100) && (CellArr[2][2].getWeightsMoveComp() == 100) && (CellArr[0][2].getWeightsMoveComp() == 100) && (CellArr[2][0].getWeightsMoveComp() == 100)) {

            tempArrList = new ArrayList();
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (i != 1 && j != 1) {
                        pairXYArr = new Pair(i, j);

                        tempArrList.add(pairXYArr);

                    }
                }
            }

            Random randomGener = new Random();
            int index = randomGener.nextInt(tempArrList.size());
            pairXYArr = tempArrList.get(index);
            CellArr[pairXYArr.getInt1()][pairXYArr.getInt2()].setPriorCellsComp(800);
            return;
        } // cell middle is taken by player1 and cell 00 && c22 && c02 && c20 is free, and no two in row
        else if ((CellArr[1][1].getWeightsMoveComp() == -500) && (checkTwoInRow() == false) && (CellArr[0][0].getWeightsMoveComp() == 100) && (CellArr[2][2].getWeightsMoveComp() == 100) && (CellArr[0][2].getWeightsMoveComp() == 100) && (CellArr[2][0].getWeightsMoveComp() == 100)) {
            tempArrList = new ArrayList();
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (i != 1 && j != 1) {
                        pairXYArr = new Pair(i, j);

                        tempArrList.add(pairXYArr);

                    }
                }
            }
            Random randomGener = new Random();
            int index = randomGener.nextInt(tempArrList.size());
            pairXYArr = tempArrList.get(index);
            CellArr[pairXYArr.getInt1()][pairXYArr.getInt2()].setPriorCellsComp(800);
            return;

        } // player1 has one cell in 00 or 22 or 02 or 20, and cell middle is free, and no two in row
        else if (((CellArr[0][0].getWeightsMoveComp() == -500) || (CellArr[2][2].getWeightsMoveComp() == -500) || (CellArr[0][2].getWeightsMoveComp() == -500) || (CellArr[2][0].getWeightsMoveComp() == -500)) && (CellArr[1][1].getWeightsMoveComp() == 100) && (checkTwoInRow() == false)) {
            CellArr[1][1].setPriorCellsComp(800);
            return;

        } //computer has one in middle, and player has opposite corners
        else if ((CellArr[1][1].getWeightsMoveComp() == 500) && (checkTwoInDiagfPlayer() == true || checkTwoInDiagbPlayer() == true) && ((CellArr[0][1].getWeightsMoveComp() == 100) && (CellArr[1][0].getWeightsMoveComp() == 100) && (CellArr[2][1].getWeightsMoveComp() == 100) && (CellArr[1][2].getWeightsMoveComp() == 100))) {

            tempArrList = new ArrayList();
            pairXYArr = new Pair(0, 1);
            tempArrList.add(pairXYArr);
            pairXYArr = new Pair(1, 0);
            tempArrList.add(pairXYArr);
            pairXYArr = new Pair(1, 2);
            tempArrList.add(pairXYArr);
            pairXYArr = new Pair(2, 1);
            tempArrList.add(pairXYArr);

            Random randomGener = new Random();
            int index = randomGener.nextInt(tempArrList.size());
            pairXYArr = tempArrList.get(index);
            CellArr[pairXYArr.getInt1()][pairXYArr.getInt2()].setPriorCellsComp(800);
            return;

        } //computer has one in middle, and player has opposite corners, and c01,c10,c21,c12 are free
        else if ((CellArr[1][1].getWeightsMoveComp() == 500) && (sumWeightsRow0 == -300 && sumWeightsRow2 == -300 && sumWeightsCol0 == -300 && sumWeightsCol2 == -300) && (sumWeightsDiagf == -500 || sumWeightsDiagb == -500) && ((CellArr[0][1].getWeightsMoveComp() == 100) && (CellArr[1][0].getWeightsMoveComp() == 100) && (CellArr[2][1].getWeightsMoveComp() == 100) && (CellArr[1][2].getWeightsMoveComp() == 100))) {

            tempArrList = new ArrayList();
            pairXYArr = new Pair(0, 1);
            tempArrList.add(pairXYArr);
            pairXYArr = new Pair(1, 0);
            tempArrList.add(pairXYArr);
            pairXYArr = new Pair(1, 2);
            tempArrList.add(pairXYArr);
            pairXYArr = new Pair(2, 1);
            tempArrList.add(pairXYArr);

            Random randomGener = new Random();
            int index = randomGener.nextInt(tempArrList.size());
            pairXYArr = tempArrList.get(index);
            CellArr[pairXYArr.getInt1()][pairXYArr.getInt2()].setPriorCellsComp(800);
            return;

        } //random from N
        else {
            tempArrList = new ArrayList();
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (CellArr[i][j].getCellState() == CellState.N.toString()) {
                        pairXYArr = new Pair(i, j);

                        tempArrList.add(pairXYArr);

                    }
                }
            }
            Random randomGener = new Random();
            int index = randomGener.nextInt(tempArrList.size());
            pairXYArr = tempArrList.get(index);
            CellArr[pairXYArr.getInt1()][pairXYArr.getInt2()].setPriorCellsComp(700);
            return;
        }

    }

    public void calcPriorCellsPlayer1() {

        // Priority2CellsPlayer1Arr = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                CellArr[i][j].setPriorCellsPlayer1(CellArr[i][j].getWeightsMoveComp());
            }
        }
        // sumWeightsRow0 Player1 has two cells in row0
        if (sumWeightsRow0 == -900) {
            for (int j = 0; j < 3; j++) {
                if (CellArr[0][j].getWeightsMoveComp() == 100) {
                    CellArr[0][j].setPriorCellsPlayer1(1000);
                    return;
                }
            }
        } // sumWeightsRow2 Player1 has two cells in row2
        else if (sumWeightsRow2 == -900) {
            for (int j = 0; j < 3; j++) {
                if (CellArr[2][j].getWeightsMoveComp() == 100) {
                    CellArr[2][j].setPriorCellsPlayer1(1000);
                    return;
                }
            }
        } // sumWeightsCol0 Player1 has two cells in col0
        else if (sumWeightsCol0 == -900) {
            for (int i = 0; i < 3; i++) {
                if (CellArr[i][0].getWeightsMoveComp() == 100) {
                    CellArr[i][0].setPriorCellsPlayer1(1000);
                    return;
                }
            }
        } // sumWeightsCol1 Player1 has two cells in col1
        else if (sumWeightsCol1 == -900) {
            for (int i = 0; i < 3; i++) {
                if (CellArr[i][1].getWeightsMoveComp() == 100) {
                    CellArr[i][1].setPriorCellsPlayer1(1000);
                    return;
                }
            }
        } // sumWeightsCol2 Player1 has two cells in col2
        else if (sumWeightsCol2 == -900) {
            for (int i = 0; i < 3; i++) {
                if (CellArr[i][2].getWeightsMoveComp() == 100) {
                    CellArr[i][2].setPriorCellsPlayer1(1000);
                    return;
                }
            }
        } // sumWeightsDiagf Player1 has two cells in Diagf
        else if (sumWeightsDiagf == -900) {
            if (CellArr[0][0].getWeightsMoveComp() == 100) {
                CellArr[0][0].setPriorCellsPlayer1(1000);
                return;
            } else if (CellArr[1][1].getWeightsMoveComp() == 100) {
                CellArr[1][1].setPriorCellsPlayer1(1000);
                return;
            } else if (CellArr[1][1].getWeightsMoveComp() == 100) {
                CellArr[2][2].setPriorCellsPlayer1(1000);
                return;
            }

        } // sumWeightsDiagb Player1 has two cells in Diagb
        else if (sumWeightsDiagb == -900) {
            if (CellArr[0][2].getWeightsMoveComp() == 100) {
                CellArr[0][2].setPriorCellsPlayer1(1000);
                return;
            } else if (CellArr[1][1].getWeightsMoveComp() == 100) {
                CellArr[1][1].setPriorCellsPlayer1(1000);
                return;
            } else if (CellArr[2][0].getWeightsMoveComp() == 100) {
                CellArr[2][0].setPriorCellsPlayer1(1000);
                return;
            }

        } // sumWeightsRow0 Pl1 has two cells in row0
        else if (sumWeightsRow0 == -900) {
            for (int j = 0; j < 3; j++) {
                if (CellArr[0][j].getWeightsMoveComp() == 100) {
                    CellArr[0][j].setPriorCellsPlayer1(900);
                    return;
                }
            }
        } // sumWeightsRow1 PL1 has two cells in row1
        else if (sumWeightsRow1 == -900) {
            for (int j = 0; j < 3; j++) {
                if (CellArr[1][j].getWeightsMoveComp() == 100) {
                    CellArr[1][j].setPriorCellsPlayer1(900);
                    return;
                }
            }
        } // sumWeightsRow2 PL1 has two cells in row2
        else if (sumWeightsRow2 == -900) {
            for (int j = 0; j < 3; j++) {
                if (CellArr[2][j].getWeightsMoveComp() == 100) {
                    CellArr[2][j].setPriorCellsPlayer1(900);
                    return;
                }
            }
        } // sumWeightsCol0 Pl1 has two cells in col0
        else if (sumWeightsCol0 == -900) {
            for (int i = 0; i < 3; i++) {
                if (CellArr[i][0].getWeightsMoveComp() == 100) {
                    CellArr[i][0].setPriorCellsPlayer1(900);
                    return;
                }
            }
        } // sumWeightsCol1 Pl1 has two cells in col1
        else if (sumWeightsCol1 == -900) {
            for (int i = 0; i < 3; i++) {
                if (CellArr[i][1].getWeightsMoveComp() == 100) {
                    CellArr[i][1].setPriorCellsPlayer1(900);
                    return;
                }
            }
        } // sumWeightsCol2 Pl1 has two cells in col2
        else if (sumWeightsCol2 == -900) {
            for (int i = 0; i < 3; i++) {
                if (CellArr[i][2].getWeightsMoveComp() == 100) {
                    CellArr[i][2].setPriorCellsPlayer1(900);
                    return;
                }
            }
        } // sumWeightsDiagf Pl1 has two cells in Diagf
        else if (sumWeightsDiagf == -900) {
            if (CellArr[0][0].getWeightsMoveComp() == 100) {
                CellArr[0][0].setPriorCellsPlayer1(900);
                return;
            } else if (CellArr[1][1].getWeightsMoveComp() == 100) {
                CellArr[1][1].setPriorCellsPlayer1(900);
                return;
            } else if (CellArr[2][2].getWeightsMoveComp() == 100) {
                CellArr[2][2].setPriorCellsPlayer1(900);
                return;
            }

        } // sumWeightsDiagb Pl1 has two cells in Diagb
        else if (sumWeightsDiagb == -900) {
            if (CellArr[0][2].getWeightsMoveComp() == 100) {
                CellArr[0][2].setPriorCellsPlayer1(900);
                return;
            } else if (CellArr[1][1].getWeightsMoveComp() == 100) {
                CellArr[1][1].setPriorCellsPlayer1(900);
                return;
            } else if (CellArr[2][0].getWeightsMoveComp() == 100) {
                CellArr[2][0].setPriorCellsPlayer1(900);
                return;
            }

        } //diagF = 100 and diagB=700
        else if (sumWeightsDiagf == 100 && sumWeightsDiagb == 700) {
            if (CellArr[0][1].getCellState() == "N") {
                CellArr[0][1].setPriorCellsPlayer1(800);
                return;

            } else if (CellArr[1][0].getCellState() == "N") {
                CellArr[1][0].setPriorCellsPlayer1(800);
                return;

            } else if (CellArr[1][2].getCellState() == "N") {
                CellArr[1][2].setPriorCellsPlayer1(800);
                return;

            } else if (CellArr[2][1].getCellState() == "N") {
                CellArr[2][1].setPriorCellsPlayer1(800);
                return;

            }

        } //diagF = 700 and diagB=100
        else if (sumWeightsDiagf == 700 && sumWeightsDiagb == 100) {
            if (CellArr[0][1].getCellState() == "N") {
                CellArr[0][1].setPriorCellsPlayer1(800);
                return;

            } else if (CellArr[1][0].getCellState() == "N") {
                CellArr[1][0].setPriorCellsPlayer1(800);
                return;

            } else if (CellArr[1][2].getCellState() == "N") {
                CellArr[1][2].setPriorCellsPlayer1(800);
                return;

            } else if (CellArr[2][1].getCellState() == "N") {
                CellArr[2][1].setPriorCellsPlayer1(800);
                return;

            }

        } //c00, c11, c22, c20, c02 is free
        else if ((comp.getPlayerQueue() == PlayerQueue.FIRST.toString()) && (CellArr[1][1].getWeightsMoveComp() == 100) && (CellArr[0][0].getWeightsMoveComp() == 100) && (CellArr[2][2].getWeightsMoveComp() == 100) && (CellArr[0][2].getWeightsMoveComp() == 100) && (CellArr[2][0].getWeightsMoveComp() == 100)) {

            tempArrList = new ArrayList();
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (i != 1 && j != 1) {
                        pairXYArr = new Pair(i, j);

                        tempArrList.add(pairXYArr);

                    }
                }
            }
            Random randomGener = new Random();
            int index = randomGener.nextInt(tempArrList.size());
            pairXYArr = tempArrList.get(index);
            CellArr[pairXYArr.getInt1()][pairXYArr.getInt2()].setPriorCellsPlayer1(800);
            return;
        } // cell middle is taken by comp and cell 00 && c22 && c02 && c20 is free, and no two in row
        else if ((CellArr[1][1].getWeightsMoveComp() == 500) && (checkTwoInRow() == false) && (CellArr[0][0].getWeightsMoveComp() == 100) && (CellArr[2][2].getWeightsMoveComp() == 100) && (CellArr[0][2].getWeightsMoveComp() == 100) && (CellArr[2][0].getWeightsMoveComp() == 100)) {
            tempArrList = new ArrayList();
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (i != 1 && j != 1) {
                        pairXYArr = new Pair(i, j);

                        tempArrList.add(pairXYArr);

                    }
                }
            }
            Random randomGener = new Random();
            int index = randomGener.nextInt(tempArrList.size());
            pairXYArr = tempArrList.get(index);
            CellArr[pairXYArr.getInt1()][pairXYArr.getInt2()].setPriorCellsPlayer1(800);
            return;

        } // comp has one cell in 00 or 22 or 02 or 20, and cell middle is free, and no two in row
        else if (((CellArr[0][0].getWeightsMoveComp() == 500) || (CellArr[2][2].getWeightsMoveComp() == 500) || (CellArr[0][2].getWeightsMoveComp() == 500) || (CellArr[2][0].getWeightsMoveComp() == 500)) && (CellArr[1][1].getWeightsMoveComp() == 100) && (checkTwoInRow() == false)) {
            CellArr[1][1].setPriorCellsPlayer1(800);
            return;

        } //player has one in middle, and comp has opposite corners, and no two in row
        else if ((CellArr[1][1].getWeightsMoveComp() == -500) && (checkTwoInRow() == false) && (sumWeightsDiagf == 500 || sumWeightsDiagb == 500) && ((CellArr[0][1].getWeightsMoveComp() == 100) && (CellArr[1][0].getWeightsMoveComp() == 100) && (CellArr[2][1].getWeightsMoveComp() == 100) && (CellArr[1][2].getWeightsMoveComp() == 100))) {

            tempArrList = new ArrayList();
            pairXYArr = new Pair(0, 1);
            tempArrList.add(pairXYArr);
            pairXYArr = new Pair(1, 0);
            tempArrList.add(pairXYArr);
            pairXYArr = new Pair(1, 2);
            tempArrList.add(pairXYArr);
            pairXYArr = new Pair(2, 1);
            tempArrList.add(pairXYArr);

            Random randomGener = new Random();
            int index = randomGener.nextInt(tempArrList.size());
            pairXYArr = tempArrList.get(index);
            CellArr[pairXYArr.getInt1()][pairXYArr.getInt2()].setPriorCellsPlayer1(800);
            return;

        } //player has one in middle, and comp has opposite corners, and c01,c10,c21,c12 are free
        else if ((CellArr[1][1].getWeightsMoveComp() == -500) && (sumWeightsRow0 == 700 && sumWeightsRow2 == 700 && sumWeightsCol0 == 700 && sumWeightsCol2 == 700) && (sumWeightsDiagf == 500 || sumWeightsDiagb == 500) && ((CellArr[0][1].getWeightsMoveComp() == 100) && (CellArr[1][0].getWeightsMoveComp() == 100) && (CellArr[2][1].getWeightsMoveComp() == 100) && (CellArr[1][2].getWeightsMoveComp() == 100))) {

            tempArrList = new ArrayList();
            pairXYArr = new Pair(0, 1);
            tempArrList.add(pairXYArr);
            pairXYArr = new Pair(1, 0);
            tempArrList.add(pairXYArr);
            pairXYArr = new Pair(1, 2);
            tempArrList.add(pairXYArr);
            pairXYArr = new Pair(2, 1);
            tempArrList.add(pairXYArr);

            Random randomGener = new Random();
            int index = randomGener.nextInt(tempArrList.size());
            pairXYArr = tempArrList.get(index);
            CellArr[pairXYArr.getInt1()][pairXYArr.getInt2()].setPriorCellsPlayer1(800);
            return;

        } //random from N
        else {
            tempArrList = new ArrayList();
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (CellArr[i][j].getCellState() == CellState.N.toString()) {
                        pairXYArr = new Pair(i, j);

                        tempArrList.add(pairXYArr);

                    }
                }
            }
            Random randomGener = new Random();
            int index = randomGener.nextInt(tempArrList.size());
            pairXYArr = tempArrList.get(index);
            CellArr[pairXYArr.getInt1()][pairXYArr.getInt2()].setPriorCellsPlayer1(700);
            return;
        }

    }

    public void calcPriorCellsPlayer2() {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                CellArr[i][j].setPriorCellsPlayer2(CellArr[i][j].getWeightsMoveComp());
            }
        }
        // sumWeightsRow0 Player2 has two cells in row0
        if (sumWeightsRow0 == -900) {
            for (int j = 0; j < 3; j++) {
                if (CellArr[0][j].getWeightsMoveComp() == 100) {
                    CellArr[0][j].setPriorCellsPlayer2(1000);
                    return;
                }
            }
        } // sumWeightsRow2 Player2 has two cells in row2
        else if (sumWeightsRow2 == -900) {
            for (int j = 0; j < 3; j++) {
                if (CellArr[2][j].getWeightsMoveComp() == 100) {
                    CellArr[2][j].setPriorCellsPlayer2(1000);
                    return;
                }
            }
        } // sumWeightsCol0 Player2 has two cells in col0
        else if (sumWeightsCol0 == -900) {
            for (int i = 0; i < 3; i++) {
                if (CellArr[i][0].getWeightsMoveComp() == 100) {
                    CellArr[i][0].setPriorCellsPlayer2(1000);
                    return;
                }
            }
        } // sumWeightsCol1 Player2 has two cells in col1
        else if (sumWeightsCol1 == -900) {
            for (int i = 0; i < 3; i++) {
                if (CellArr[i][1].getWeightsMoveComp() == 100) {
                    CellArr[i][1].setPriorCellsPlayer2(1000);
                    return;
                }
            }
        } // sumWeightsCol2 Player2 has two cells in col2
        else if (sumWeightsCol2 == -900) {
            for (int i = 0; i < 3; i++) {
                if (CellArr[i][2].getWeightsMoveComp() == 100) {
                    CellArr[i][2].setPriorCellsPlayer2(1000);
                    return;
                }
            }
        } // sumWeightsDiagf Player2 has two cells in Diagf
        else if (sumWeightsDiagf == -900) {
            if (CellArr[0][0].getWeightsMoveComp() == 100) {
                CellArr[0][0].setPriorCellsPlayer2(1000);
                return;
            } else if (CellArr[1][1].getWeightsMoveComp() == 100) {
                CellArr[1][1].setPriorCellsPlayer2(1000);
                return;
            } else if (CellArr[1][1].getWeightsMoveComp() == 100) {
                CellArr[2][2].setPriorCellsPlayer2(1000);
                return;
            }

        } // sumWeightsDiagb Player2 has two cells in Diagb
        else if (sumWeightsDiagb == -900) {
            if (CellArr[0][2].getWeightsMoveComp() == 100) {
                CellArr[0][2].setPriorCellsPlayer2(1000);
                return;
            } else if (CellArr[1][1].getWeightsMoveComp() == 100) {
                CellArr[1][1].setPriorCellsPlayer2(1000);
                return;
            } else if (CellArr[2][0].getWeightsMoveComp() == 100) {
                CellArr[2][0].setPriorCellsPlayer2(1000);
                return;
            }

        } // sumWeightsRow0 Pl1 has two cells in row0
        else if (sumWeightsRow0 == -900) {
            for (int j = 0; j < 3; j++) {
                if (CellArr[0][j].getWeightsMoveComp() == 100) {
                    CellArr[0][j].setPriorCellsPlayer2(900);
                    return;
                }
            }
        } // sumWeightsRow1 PL1 has two cells in row1
        else if (sumWeightsRow1 == -900) {
            for (int j = 0; j < 3; j++) {
                if (CellArr[1][j].getWeightsMoveComp() == 100) {
                    CellArr[1][j].setPriorCellsPlayer2(900);
                    return;
                }
            }
        } // sumWeightsRow2 PL1 has two cells in row2
        else if (sumWeightsRow2 == -900) {
            for (int j = 0; j < 3; j++) {
                if (CellArr[2][j].getWeightsMoveComp() == 100) {
                    CellArr[2][j].setPriorCellsPlayer2(900);
                    return;
                }
            }
        } // sumWeightsCol0 Pl1 has two cells in col0
        else if (sumWeightsCol0 == -900) {
            for (int i = 0; i < 3; i++) {
                if (CellArr[i][0].getWeightsMoveComp() == 100) {
                    CellArr[i][0].setPriorCellsPlayer2(900);
                    return;
                }
            }
        } // sumWeightsCol1 Pl1 has two cells in col1
        else if (sumWeightsCol1 == -900) {
            for (int i = 0; i < 3; i++) {
                if (CellArr[i][1].getWeightsMoveComp() == 100) {
                    CellArr[i][1].setPriorCellsPlayer2(900);
                    return;
                }
            }
        } // sumWeightsCol2 Pl1 has two cells in col2
        else if (sumWeightsCol2 == -900) {
            for (int i = 0; i < 3; i++) {
                if (CellArr[i][2].getWeightsMoveComp() == 100) {
                    CellArr[i][2].setPriorCellsPlayer2(900);
                    return;
                }
            }
        } // sumWeightsDiagf Pl1 has two cells in Diagf
        else if (sumWeightsDiagf == -900) {
            if (CellArr[0][0].getWeightsMoveComp() == 100) {
                CellArr[0][0].setPriorCellsPlayer2(900);
                return;
            } else if (CellArr[1][1].getWeightsMoveComp() == 100) {
                CellArr[1][1].setPriorCellsPlayer2(900);
                return;
            } else if (CellArr[2][2].getWeightsMoveComp() == 100) {
                CellArr[2][2].setPriorCellsPlayer2(900);
                return;
            }

        } // sumWeightsDiagb Pl1 has two cells in Diagb
        else if (sumWeightsDiagb == -900) {
            if (CellArr[0][2].getWeightsMoveComp() == 100) {
                CellArr[0][2].setPriorCellsPlayer2(900);
                return;
            } else if (CellArr[1][1].getWeightsMoveComp() == 100) {
                CellArr[1][1].setPriorCellsPlayer2(900);
                return;
            } else if (CellArr[2][0].getWeightsMoveComp() == 100) {
                CellArr[2][0].setPriorCellsPlayer2(900);
                return;
            }

        } //diagF = 100 and diagB=700
        else if (sumWeightsDiagf == 100 && sumWeightsDiagb == 700) {
            if (CellArr[0][1].getCellState() == "N") {
                CellArr[0][1].setPriorCellsPlayer2(800);
                return;

            } else if (CellArr[1][0].getCellState() == "N") {
                CellArr[1][0].setPriorCellsPlayer2(800);
                return;

            } else if (CellArr[1][2].getCellState() == "N") {
                CellArr[1][2].setPriorCellsPlayer2(800);
                return;

            } else if (CellArr[2][1].getCellState() == "N") {
                CellArr[2][1].setPriorCellsPlayer2(800);
                return;

            }

        } //diagF = 700 and diagB=100
        else if (sumWeightsDiagf == 700 && sumWeightsDiagb == 100) {
            if (CellArr[0][1].getCellState() == "N") {
                CellArr[0][1].setPriorCellsPlayer2(800);
                return;

            } else if (CellArr[1][0].getCellState() == "N") {
                CellArr[1][0].setPriorCellsPlayer2(800);
                return;

            } else if (CellArr[1][2].getCellState() == "N") {
                CellArr[1][2].setPriorCellsPlayer2(800);
                return;

            } else if (CellArr[2][1].getCellState() == "N") {
                CellArr[2][1].setPriorCellsPlayer2(800);
                return;

            }

        } //c00, c11, c22, c20, c02 is free
        else if ((comp.getPlayerQueue() == PlayerQueue.FIRST.toString()) && (CellArr[1][1].getWeightsMoveComp() == 100) && (CellArr[0][0].getWeightsMoveComp() == 100) && (CellArr[2][2].getWeightsMoveComp() == 100) && (CellArr[0][2].getWeightsMoveComp() == 100) && (CellArr[2][0].getWeightsMoveComp() == 100)) {

            tempArrList = new ArrayList();
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (i != 1 && j != 1) {
                        pairXYArr = new Pair(i, j);

                        tempArrList.add(pairXYArr);

                    }
                }
            }
            Random randomGener = new Random();
            int index = randomGener.nextInt(tempArrList.size());
            pairXYArr = tempArrList.get(index);
            CellArr[pairXYArr.getInt1()][pairXYArr.getInt2()].setPriorCellsPlayer2(800);
            return;
        } // cell middle is taken by comp and cell 00 && c22 && c02 && c20 is free, and no two in row
        else if ((CellArr[1][1].getWeightsMoveComp() == 500) && (checkTwoInRow() == false) && (CellArr[0][0].getWeightsMoveComp() == 100) && (CellArr[2][2].getWeightsMoveComp() == 100) && (CellArr[0][2].getWeightsMoveComp() == 100) && (CellArr[2][0].getWeightsMoveComp() == 100)) {
            tempArrList = new ArrayList();
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (i != 1 && j != 1) {
                        pairXYArr = new Pair(i, j);

                        tempArrList.add(pairXYArr);

                    }
                }
            }
            Random randomGener = new Random();
            int index = randomGener.nextInt(tempArrList.size());
            pairXYArr = tempArrList.get(index);
            CellArr[pairXYArr.getInt1()][pairXYArr.getInt2()].setPriorCellsPlayer2(800);
            return;

        } // comp has one cell in 00 or 22 or 02 or 20, and cell middle is free, and no two in row
        else if (((CellArr[0][0].getWeightsMoveComp() == 500) || (CellArr[2][2].getWeightsMoveComp() == 500) || (CellArr[0][2].getWeightsMoveComp() == 500) || (CellArr[2][0].getWeightsMoveComp() == 500)) && (CellArr[1][1].getWeightsMoveComp() == 100) && (checkTwoInRow() == false)) {
            CellArr[1][1].setPriorCellsPlayer2(800);
            return;

        } //player has one in middle, and comp has opposite corners, and no two in row
        else if ((CellArr[1][1].getWeightsMoveComp() == -500) && (checkTwoInRow() == false) && (sumWeightsDiagf == 500 || sumWeightsDiagb == 500) && ((CellArr[0][1].getWeightsMoveComp() == 100) && (CellArr[1][0].getWeightsMoveComp() == 100) && (CellArr[2][1].getWeightsMoveComp() == 100) && (CellArr[1][2].getWeightsMoveComp() == 100))) {

            tempArrList = new ArrayList();
            pairXYArr = new Pair(0, 1);
            tempArrList.add(pairXYArr);
            pairXYArr = new Pair(1, 0);
            tempArrList.add(pairXYArr);
            pairXYArr = new Pair(1, 2);
            tempArrList.add(pairXYArr);
            pairXYArr = new Pair(2, 1);
            tempArrList.add(pairXYArr);

            Random randomGener = new Random();
            int index = randomGener.nextInt(tempArrList.size());
            pairXYArr = tempArrList.get(index);
            CellArr[pairXYArr.getInt1()][pairXYArr.getInt2()].setPriorCellsPlayer2(800);
            return;

        } //player has one in middle, and comp has opposite corners, and c01,c10,c21,c12 are free
        else if ((CellArr[1][1].getWeightsMoveComp() == -500) && (sumWeightsRow0 == 700 && sumWeightsRow2 == 700 && sumWeightsCol0 == 700 && sumWeightsCol2 == 700) && (sumWeightsDiagf == 500 || sumWeightsDiagb == 500) && ((CellArr[0][1].getWeightsMoveComp() == 100) && (CellArr[1][0].getWeightsMoveComp() == 100) && (CellArr[2][1].getWeightsMoveComp() == 100) && (CellArr[1][2].getWeightsMoveComp() == 100))) {

            tempArrList = new ArrayList();
            pairXYArr = new Pair(0, 1);
            tempArrList.add(pairXYArr);
            pairXYArr = new Pair(1, 0);
            tempArrList.add(pairXYArr);
            pairXYArr = new Pair(1, 2);
            tempArrList.add(pairXYArr);
            pairXYArr = new Pair(2, 1);
            tempArrList.add(pairXYArr);

            Random randomGener = new Random();
            int index = randomGener.nextInt(tempArrList.size());
            pairXYArr = tempArrList.get(index);
            CellArr[pairXYArr.getInt1()][pairXYArr.getInt2()].setPriorCellsPlayer2(800);
            return;

        } //random from N
        else {
            tempArrList = new ArrayList();
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (CellArr[i][j].getCellState() == CellState.N.toString()) {
                        pairXYArr = new Pair(i, j);

                        tempArrList.add(pairXYArr);

                    }
                }
            }
            Random randomGener = new Random();
            int index = randomGener.nextInt(tempArrList.size());
            pairXYArr = tempArrList.get(index);
            CellArr[pairXYArr.getInt1()][pairXYArr.getInt2()].setPriorCellsPlayer2(700);
            return;
        }

    }

    public void calcSumWeightsMoveComp() {
        sumWeightsRow0 = 0;
        sumWeightsRow1 = 0;
        sumWeightsRow2 = 0;
        sumWeightsCol0 = 0;
        sumWeightsCol1 = 0;
        sumWeightsCol2 = 0;
        sumWeightsDiagf = 0;
        sumWeightsDiagb = 0;
        for (int i = 0; i < 3; i++) {
            int AsumWeightsCol0 = CellArr[i][0].getWeightsMoveComp();
            sumWeightsCol0 = AsumWeightsCol0 + sumWeightsCol0;
            int AsumWeightsCol1 = CellArr[i][1].getWeightsMoveComp();
            sumWeightsCol1 = AsumWeightsCol1 + sumWeightsCol1;
            int AsumWeightsCol2 = CellArr[i][2].getWeightsMoveComp();
            sumWeightsCol2 = AsumWeightsCol2 + sumWeightsCol2;
        }
        for (int j = 0; j < 3; j++) {
            int AsumWeightsRow0 = CellArr[0][j].getWeightsMoveComp();
            sumWeightsRow0 = AsumWeightsRow0 + sumWeightsRow0;
            int AsumWeightsRow1 = CellArr[1][j].getWeightsMoveComp();
            sumWeightsRow1 = AsumWeightsRow1 + sumWeightsRow1;
            int AsumWeightsRow2 = CellArr[2][j].getWeightsMoveComp();
            sumWeightsRow2 = AsumWeightsRow2 + sumWeightsRow2;
        }

        sumWeightsDiagf = CellArr[0][0].getWeightsMoveComp() + CellArr[1][1].getWeightsMoveComp() + CellArr[2][2].getWeightsMoveComp();
        sumWeightsDiagb = CellArr[0][2].getWeightsMoveComp() + CellArr[1][1].getWeightsMoveComp() + CellArr[2][0].getWeightsMoveComp();
    }

    public void calcSumWeightsMovePlayer1() {
        sumWeightsRow0 = 0;
        sumWeightsRow1 = 0;
        sumWeightsRow2 = 0;
        sumWeightsCol0 = 0;
        sumWeightsCol1 = 0;
        sumWeightsCol2 = 0;
        sumWeightsDiagf = 0;
        sumWeightsDiagb = 0;
        for (int i = 0; i < 3; i++) {
            int AsumWeightsCol0 = CellArr[i][0].weightsMovePlayer1;
            sumWeightsCol0 = AsumWeightsCol0 + sumWeightsCol0;
            int AsumWeightsCol1 = CellArr[i][1].weightsMovePlayer1;
            sumWeightsCol1 = AsumWeightsCol1 + sumWeightsCol1;
            int AsumWeightsCol2 = CellArr[i][2].weightsMovePlayer1;
            sumWeightsCol2 = AsumWeightsCol2 + sumWeightsCol2;
        }
        for (int j = 0; j < 3; j++) {
            int AsumWeightsRow0 = CellArr[0][j].weightsMovePlayer1;
            sumWeightsRow0 = AsumWeightsRow0 + sumWeightsRow0;
            int AsumWeightsRow1 = CellArr[1][j].weightsMovePlayer1;
            sumWeightsRow1 = AsumWeightsRow1 + sumWeightsRow1;
            int AsumWeightsRow2 = CellArr[2][j].weightsMovePlayer1;
            sumWeightsRow2 = AsumWeightsRow2 + sumWeightsRow2;
        }

        sumWeightsDiagf = CellArr[0][0].weightsMovePlayer1 + CellArr[1][1].weightsMovePlayer1 + CellArr[2][2].weightsMovePlayer1;
        sumWeightsDiagb = CellArr[0][2].weightsMovePlayer1 + CellArr[1][1].weightsMovePlayer1 + CellArr[2][0].weightsMovePlayer1;
    }

    public void calcSumWeightsMovePlayer2() {
        sumWeightsRow0 = 0;
        sumWeightsRow1 = 0;
        sumWeightsRow2 = 0;
        sumWeightsCol0 = 0;
        sumWeightsCol1 = 0;
        sumWeightsCol2 = 0;
        sumWeightsDiagf = 0;
        sumWeightsDiagb = 0;
        for (int i = 0; i < 3; i++) {
            int AsumWeightsCol0 = CellArr[i][0].weightsMovePlayer2;
            sumWeightsCol0 = AsumWeightsCol0 + sumWeightsCol0;
            int AsumWeightsCol1 = CellArr[i][1].weightsMovePlayer2;
            sumWeightsCol1 = AsumWeightsCol1 + sumWeightsCol1;
            int AsumWeightsCol2 = CellArr[i][2].weightsMovePlayer2;
            sumWeightsCol2 = AsumWeightsCol2 + sumWeightsCol2;
        }
        for (int j = 0; j < 3; j++) {
            int AsumWeightsRow0 = CellArr[0][j].weightsMovePlayer2;
            sumWeightsRow0 = AsumWeightsRow0 + sumWeightsRow0;
            int AsumWeightsRow1 = CellArr[1][j].weightsMovePlayer2;
            sumWeightsRow1 = AsumWeightsRow1 + sumWeightsRow1;
            int AsumWeightsRow2 = CellArr[2][j].weightsMovePlayer2;
            sumWeightsRow2 = AsumWeightsRow2 + sumWeightsRow2;
        }

        sumWeightsDiagf = CellArr[0][0].weightsMovePlayer2 + CellArr[1][1].weightsMovePlayer2 + CellArr[2][2].weightsMovePlayer2;
        sumWeightsDiagb = CellArr[0][2].weightsMovePlayer2 + CellArr[1][1].weightsMovePlayer2 + CellArr[2][0].weightsMovePlayer2;
    }

    public int getWeightMoveComp(int a, int b) {
        int s = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (a == i && b == j) {
                    s = CellArr[i][j].getWeightsMoveComp();
                }
            }

        }
        return s;
    }

    public int getWeightMovePlayer1(int a, int b) {
        int s = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (a == i && b == i) {
                    s = CellArr[i][j].getWeightsMovePlayer1();
                }
            }

        }
        return s;
    }

    public int getWeightMovePlayer2(int a, int b) {
        int s = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (a == i && b == i) {
                    s = CellArr[i][j].getWeightsMovePlayer2();
                }
            }

        }
        return s;
    }

    public void setUpWeighstMovePlayer1() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (null != CellArr[i][j]) {
                    switch (CellArr[i][j].getCellState()) {
                        case "N":
                            CellArr[i][j].setWeightsMovePlayer1(100);
                            break;
                        case "PL1TAKEN":
                            CellArr[i][j].setWeightsMovePlayer1(500);
                            break;
                        case "COMPTAKEN":
                            CellArr[i][j].setWeightsMovePlayer1(-500);
                            break;
                        case "PL2TAKEN":
                            CellArr[i][j].setWeightsMovePlayer1(-500);
                            break;
                        default:
                            break;
                    }
                }
            }
        }
    }

    public void setUpWeighstMovePlayer2() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (null != CellArr[i][j]) {
                    switch (CellArr[i][j].getCellState()) {
                        case "N":
                            CellArr[i][j].setWeightsMovePlayer2(100);
                            break;
                        case "PL2TAKEN":
                            CellArr[i][j].setWeightsMovePlayer2(500);
                            break;
                        case "COMPTAKEN":
                            CellArr[i][j].setWeightsMovePlayer1(-500);
                            break;
                        case "PL1TAKEN":
                            CellArr[i][j].setWeightsMovePlayer1(-500);
                            break;
                        default:
                            break;
                    }
                }
            }
        }
    }

    public void setUpWeightsMoveComp() {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (null != CellArr[i][j]) {
                    switch (CellArr[i][j].getCellState()) {
                        case "N":
                            CellArr[i][j].setWeightsMoveComp(100);
                            break;
                        case "COMPTAKEN":
                            CellArr[i][j].setWeightsMoveComp(500);
                            break;
                        case "PL1TAKEN":
                            CellArr[i][j].setWeightsMoveComp(-500);
                            break;
                        case "PL2TAKEN":
                            CellArr[i][j].setWeightsMoveComp(-500);
                            break;
                        default:
                            break;
                    }
                }
            }
        }
    }

    public void setUpAvailMovesPlayer1() {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (null != CellArr[i][j]) {
                    switch (CellArr[i][j].getCellState()) {
                        case "N":
                            CellArr[i][j].setMovePlayer1(CellState.PLAYER1.toString());
                            break;
                        case "COMPTAKEN":
                            CellArr[i][j].setMovePlayer1(CellState.COMPTAKEN.toString());
                            break;
                        case "PL1TAKEN":
                            CellArr[i][j].setMovePlayer1(CellState.PL1TAKEN.toString());
                            break;
                        case "PL2TAKEN":
                            CellArr[i][j].setMovePlayer1(CellState.PL2TAKEN.toString());
                            break;
                        default:
                            break;
                    }
                }
            }
        }
    }

    public void setUpAvailMovesComp() {
        //MoveCompArr = new String[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (null != CellArr[i][j]) {
                    switch (CellArr[i][j].getCellState()) {
                        case "N":
                            CellArr[i][j].setMoveComp(CellState.COMP.toString());
                            break;
                        case "PL1TAKEN":
                            CellArr[i][j].setMoveComp(CellState.PL1TAKEN.toString());
                            break;
                        case "COMPTAKEN":
                            CellArr[i][j].setMoveComp(CellState.COMPTAKEN.toString());
                            break;
                        case "PL2TAKEN":
                            CellArr[i][j].setMoveComp(CellState.PL2TAKEN.toString());
                            break;
                        default:
                            break;
                    }
                }
            }
        }
    }

    public void setUpAvailMovesPlayer2() {
        //MovePlayer2Arr = new String[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (null != CellArr[i][j]) {
                    switch (CellArr[i][j].getCellState()) {
                        case "N":
                            CellArr[i][j].setMovePlayer2(CellState.PLAYER2.toString());
                            break;
                        case "PL1TAKEN":
                            CellArr[i][j].setMovePlayer2(CellState.PL1TAKEN.toString());
                            break;
                        case "COMPTAKEN":
                            CellArr[i][j].setMovePlayer2(CellState.COMPTAKEN.toString());
                            break;
                        case "PL2TAKEN":
                            CellArr[i][j].setMovePlayer2(CellState.PL2TAKEN.toString());
                            break;
                        default:
                            break;
                    }
                }
            }
        }
    }

    public String getAvailMovePlayer1(int a, int b) {
        String s = "";
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == a && j == b) {
                    s = CellArr[i][j].getMovePlayer1();
                }
            }
        }
        return s;
    }

    public String getAvailMovePlayer2(int a, int b) {
        String s = "";
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == a && j == b) {
                    s = CellArr[i][j].getMovePlayer2();
                }
            }
        }
        return s;
    }

    public String getAvailMoveComp(int a, int b) {
        String s = "";
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == a && j == b) {
                    s = CellArr[i][j].getMoveComp();
                }
            }
        }
        return s;
    }

    public void printAvailMovesPlayer1() {
        System.out.println("FreeFirstMovePlayer1 for i=0 ");
        for (int j = 0; j < 3; j++) {
            int i = 0;
            System.out.print(i + "" + j + " " + CellArr[i][j].getMovePlayer1() + " , ");
        }
        System.out.println("\n");

        System.out.println("FreeFirstMovePlayer1 for i=1 ");
        for (int j = 0; j < 3; j++) {
            int i = 1;
            System.out.print(i + "" + j + " " + CellArr[i][j].getMovePlayer1() + " , ");
        }
        System.out.println("\n");

        System.out.println("FreeFirstMovePlayer1 for i=2 ");
        for (int j = 0; j < 3; j++) {
            int i = 2;
            System.out.print(i + "" + j + " " + CellArr[i][j].getMovePlayer1() + " , ");
        }
        System.out.println("\n");

    }

    public void printAvailMovesComp() {
        System.out.println("FreeFirstMoveComp for i=0 ");
        for (int j = 0; j < 3; j++) {
            int i = 0;
            System.out.print(i + "" + j + " " + CellArr[i][j].getMoveComp() + " , ");
        }
        System.out.println("\n");

        System.out.println("FreeFirstMoveComp for i=1 ");
        for (int j = 0; j < 3; j++) {
            int i = 1;
            System.out.print(i + "" + j + " " + CellArr[i][j].getMoveComp() + " , ");
        }
        System.out.println("\n");

        System.out.println("FreeFirstMoveComp for i=2 ");
        for (int j = 0; j < 3; j++) {
            int i = 2;
            System.out.print(i + "" + j + " " + CellArr[i][j].getMoveComp() + " , ");
        }
        System.out.println("\n");

    }

    public void printAvailMovesPlayer2() {
        System.out.println("FreeFirstMovePlayer2 for i=0 ");
        for (int j = 0; j < 3; j++) {
            int i = 0;
            System.out.print(i + "" + j + " " + CellArr[i][j].getMovePlayer2() + " , ");
        }
        System.out.println("\n");

        System.out.println("FreeFirstMovePlayer2 for i=1 ");
        for (int j = 0; j < 3; j++) {
            int i = 1;
            System.out.print(i + "" + j + " " + CellArr[i][j].getMovePlayer2() + " , ");
        }
        System.out.println("\n");

        System.out.println("FreeFirstMovePlayer2 for i=2 ");
        for (int j = 0; j < 3; j++) {
            int i = 2;
            System.out.print(i + "" + j + " " + CellArr[i][j].getMovePlayer2() + " , ");
        }
        System.out.println("\n");

    }

    public void printWeightsMoveComp() {
        System.out.println("weightsMoveComp for i=0 ");
        for (int j = 0; j < 3; j++) {
            int i = 0;
            System.out.print(i + "" + j + " " + CellArr[i][j].getWeightsMoveComp() + " , ");
        }
        System.out.println("\n");

        System.out.println("weightsMoveComp for i=1 ");
        for (int j = 0; j < 3; j++) {
            int i = 1;
            System.out.print(i + "" + j + " " + CellArr[i][j].getWeightsMoveComp() + " , ");
        }
        System.out.println("\n");

        System.out.println("weightsMoveComp for i=2 ");
        for (int j = 0; j < 3; j++) {
            int i = 2;
            System.out.print(i + "" + j + " " + CellArr[i][j].getWeightsMoveComp() + " , ");
        }
        System.out.println("\n");

    }

    public void printWeightsMovePlayer1() {
        System.out.println("weightsMovePlayer1 for i=0 ");
        for (int j = 0; j < 3; j++) {
            int i = 0;
            System.out.print(i + "" + j + " " + CellArr[i][j].getWeightsMovePlayer1() + " , ");
        }
        System.out.println("\n");

        System.out.println("weightsMovePlayer1 for i=1 ");
        for (int j = 0; j < 3; j++) {
            int i = 1;
            System.out.print(i + "" + j + " " + CellArr[i][j].getWeightsMovePlayer1() + " , ");
        }
        System.out.println("\n");

        System.out.println("weightsMovePlayer1 for i=2 ");
        for (int j = 0; j < 3; j++) {
            int i = 2;
            System.out.print(i + "" + j + " " + CellArr[i][j].getWeightsMovePlayer1() + " , ");
        }
        System.out.println("\n");

    }

    public void printWeightsMovePlayer2() {
        System.out.println("weightsMovePlayer2 for i=0 ");
        for (int j = 0; j < 3; j++) {
            int i = 0;
            System.out.print(i + "" + j + " " + CellArr[i][j].getWeightsMovePlayer2() + " , ");
        }
        System.out.println("\n");

        System.out.println("weightsMovePlayer2 for i=1 ");
        for (int j = 0; j < 3; j++) {
            int i = 1;
            System.out.print(i + "" + j + " " + CellArr[i][j].getWeightsMovePlayer2() + " , ");
        }
        System.out.println("\n");

        System.out.println("weightsMovePlayer2 for i=2 ");
        for (int j = 0; j < 3; j++) {
            int i = 2;
            System.out.print(i + "" + j + " " + CellArr[i][j].getWeightsMovePlayer2() + " , ");
        }
        System.out.println("\n");

    }

    public void printPriorCellsComp() {
        System.out.println("priorCellsComp for i=0 ");
        for (int j = 0; j < 3; j++) {
            int i = 0;
            System.out.print(i + "" + j + " " + CellArr[i][j].getPriorCellsComp() + " , ");
        }
        System.out.println("\n");

        System.out.println("priorCellsComp for i=1 ");
        for (int j = 0; j < 3; j++) {
            int i = 1;
            System.out.print(i + "" + j + " " + CellArr[i][j].getPriorCellsComp() + " , ");
        }
        System.out.println("\n");

        System.out.println("priorCellsComp for i=2 ");
        for (int j = 0; j < 3; j++) {
            int i = 2;
            System.out.print(i + "" + j + " " + CellArr[i][j].getPriorCellsComp() + " , ");
        }
        System.out.println("\n");

    }

    public void printPriorCellsPlayer1() {
        System.out.println("priorCellsPlayer1 for i=0 ");
        for (int j = 0; j < 3; j++) {
            int i = 0;
            System.out.print(i + "" + j + " " + CellArr[i][j].getPriorCellsPlayer1() + " , ");
        }
        System.out.println("\n");

        System.out.println("priorCellsPlayer1 for i=1 ");
        for (int j = 0; j < 3; j++) {
            int i = 1;
            System.out.print(i + "" + j + " " + CellArr[i][j].getPriorCellsPlayer1() + " , ");
        }
        System.out.println("\n");

        System.out.println("priorCellsPlayer1 for i=2 ");
        for (int j = 0; j < 3; j++) {
            int i = 2;
            System.out.print(i + "" + j + " " + CellArr[i][j].getPriorCellsPlayer1() + " , ");
        }
        System.out.println("\n");

    }

    public void printPriorCellsPlayer2() {
        System.out.println("priorCellsPlayer2 for i=0 ");
        for (int j = 0; j < 3; j++) {
            int i = 0;
            System.out.print(i + "" + j + " " + CellArr[i][j].getPriorCellsPlayer2() + " , ");
        }
        System.out.println("\n");

        System.out.println("priorCellsPlayer2 for i=1 ");
        for (int j = 0; j < 3; j++) {
            int i = 1;
            System.out.print(i + "" + j + " " + CellArr[i][j].getPriorCellsPlayer2() + " , ");
        }
        System.out.println("\n");

        System.out.println("priorCellsPlayer2 for i=2 ");
        for (int j = 0; j < 3; j++) {
            int i = 2;
            System.out.print(i + "" + j + " " + CellArr[i][j].getPriorCellsPlayer2() + " , ");
        }
        System.out.println("\n");

    }

    public boolean checkNullToogleForPl1() {
        return (groupPlayer1.getSelectedToggle() == null) && ((groupPlayer2.getSelectedToggle() == null) || (groupComp.getSelectedToggle() == null));
    }

    public boolean checkNullToogleForComp() {
        return (groupComp.getSelectedToggle() == null) && ((groupPlayer1.getSelectedToggle() == null) || (groupPlayer2.getSelectedToggle() == null));
    }

    public boolean checkNullToogleForPl2() {
        return (groupPlayer2.getSelectedToggle() == null) && ((groupPlayer1.getSelectedToggle() == null) || (groupComp.getSelectedToggle() == null));
    }

    public boolean checkNullGroupPlayer1Signs() {
        return groupPlayer1Signs.getSelectedToggle() == null;
    }

    public boolean checkNullGroupPlayer2Signs() {
        return groupPlayer2Signs.getSelectedToggle() == null;
    }

    public boolean checkNullGroupCompSigns() {
        return groupCompSign.getSelectedToggle() == null;
    }

    public boolean checkNullGroupPlayer1() {
        return groupPlayer1.getSelectedToggle() == null;
    }

    public boolean checkNullGroupPlayer2() {
        return groupPlayer2.getSelectedToggle() == null;
    }

    public boolean checkNullGroupComp() {
        return groupComp.getSelectedToggle() == null;
    }

    public void fireButtonComp() {
        if ((comp.getPlayerState() == PlayerState.IN_GAME.toString()) && (comp.getPlayerQueue() == PlayerQueue.FIRST.toString())) {
            setUpAvailMovesComp();

            setUpWeightsMoveComp();

            calcSumWeightsMoveComp();

            calcPriorCellsComp();

            if (player1.getPlayerState() == PlayerState.IN_GAME.toString()) {
                calcPriorCellsPlayer1();

            }
            if (player2.getPlayerState() == PlayerState.IN_GAME.toString()) {
                calcPriorCellsPlayer2();

            }

            if (getXPriorCellsComp() != 5) {
                int i = getXPriorCellsComp();
                int j = getYPriorCellsComp();
                if (CellArr[i][j].getMoveComp() == PlayerName.COMP.toString()) {
                    fireRowXComp = i;
                    fireColYComp = j;
                    return;
                }

            } else if ((getXPriorCellsPlayer1() != 5) && (player1.getPlayerState() == PlayerState.IN_GAME.toString())) {
                int i = getXPriorCellsPlayer1();
                int j = getYPriorCellsPlayer1();
                if (CellArr[i][j].getMoveComp() == PlayerName.COMP.toString()) {
                    fireRowXComp = i;
                    fireColYComp = j;
                    return;
                }

            } else if ((getXPriorCellsPlayer2() != 5) && (player2.getPlayerState() == PlayerState.IN_GAME.toString())) {
                int i = getXPriorCellsPlayer2();
                int j = getYPriorCellsPlayer2();
                if (CellArr[i][j].getMoveComp() == PlayerName.COMP.toString()) {
                    fireRowXComp = i;
                    fireColYComp = j;
                    return;
                }

            }
        }

    }

    public int getFireRowXComp() {
        return fireRowXComp;
    }

    public int getfireColYComp() {
        return fireColYComp;
    }

    public void setFireRowXMouseBut(int fireRowXMouseBut) {
        this.fireRowXMouseBut = fireRowXMouseBut;
    }

    public void setFireRowYMouseBut(int fireColYMouseBut) {
        this.fireColYMouseBut = fireColYMouseBut;
    }

    public void setFireRowISign(int fireRowISign) {
        this.fireRowISign = fireRowISign;
    }

    public void setFireColJSign(int fireColJSign) {
        this.fireColJSign = fireColJSign;
    }

    public void setFireSign(String fireSign) {
        this.fireSign = fireSign;

    }

    public Image getImageX() {
        Image image = new Image("img/x.png");
        return image;

    }

    public String getCheckPlayersQueueAndReturnSign(int i, int j) {

        if ((player1.getPlayerState() == PlayerState.IN_GAME.toString()) && (player1.getPlayerQueue() == PlayerQueue.FIRST.toString()) && CellArr[i][j].getCellState() != CellState.FREE.toString()) {

            player1.setPlayerQueue(PlayerQueue.SECOND.toString());
            addPlayerNametoCellState(PlayerName.PL1TAKEN.toString(), i, j);
            addWeightNumPlayerToCell(i, j);

            setUpAvailMovesPlayer1();
            if (player2.getPlayerQueue() == PlayerQueue.SECOND.toString() && player2.getPlayerState() == PlayerState.IN_GAME.toString()) {
                player2.setPlayerQueue(PlayerQueue.FIRST.toString());
            } else if (comp.getPlayerQueue() == PlayerQueue.SECOND.toString() && comp.getPlayerState() == PlayerState.IN_GAME.toString()) {
                comp.setPlayerQueue(PlayerQueue.FIRST.toString());
            }

            if (null != player1.getPlayerSign()) {
                switch (player1.getPlayerSign()) {
                    case "X_SIGN":
                        returnPlayerSign = player1.getPlayerSign();
                        return returnPlayerSign;
                    case "O_SIGN":
                        returnPlayerSign = player1.getPlayerSign();
                        return returnPlayerSign;
                    case "T_SIGN":
                        returnPlayerSign = player1.getPlayerSign();
                        return returnPlayerSign;
                    default:
                        break;
                }
            }

        } else if ((player2.getPlayerState() == PlayerState.IN_GAME.toString()) && (player2.getPlayerQueue() == PlayerQueue.FIRST.toString()) && CellArr[i][j].getCellState() != CellState.FREE.toString()) {

            player2.setPlayerQueue(PlayerQueue.SECOND.toString());
            addPlayerNametoCellState(PlayerName.PL2TAKEN.toString(), i, j);
            addWeightNumPlayerToCell(i, j);

            setUpAvailMovesPlayer2();
            if (player1.getPlayerQueue() == PlayerQueue.SECOND.toString() && player1.getPlayerState() == PlayerState.IN_GAME.toString()) {
                player1.setPlayerQueue(PlayerQueue.FIRST.toString());
            } else if (comp.getPlayerQueue() == PlayerQueue.SECOND.toString() && comp.getPlayerState() == PlayerState.IN_GAME.toString()) {
                comp.setPlayerQueue(PlayerQueue.FIRST.toString());
            }

            if (null != player2.getPlayerSign()) {
                switch (player2.getPlayerSign()) {
                    case "PLUS_SIGN":
                        returnPlayerSign = player2.getPlayerSign();
                        return returnPlayerSign;
                    case "Q_SIGN":
                        returnPlayerSign = player2.getPlayerSign();
                        return returnPlayerSign;
                    case "V_SIGN":
                        returnPlayerSign = player2.getPlayerSign();
                        return returnPlayerSign;
                    default:
                        break;
                }
            }
        } else if ((comp.getPlayerState() == PlayerState.IN_GAME.toString()) && (comp.getPlayerQueue() == PlayerQueue.FIRST.toString()) && CellArr[i][j].getCellState() != CellState.FREE.toString()) {

            comp.setPlayerQueue(PlayerQueue.SECOND.toString());
            addPlayerNametoCellState(PlayerName.COMPTAKEN.toString(), i, j);
            addWeightNumPlayerToCell(i, j);

            setUpAvailMovesComp();

            if (player1.getPlayerQueue() == PlayerQueue.SECOND.toString() && player1.getPlayerState() == PlayerState.IN_GAME.toString()) {
                player1.setPlayerQueue(PlayerQueue.FIRST.toString());
            } else if (player2.getPlayerQueue() == PlayerQueue.SECOND.toString() && player2.getPlayerState() == PlayerState.IN_GAME.toString()) {
                player2.setPlayerQueue(PlayerQueue.FIRST.toString());
            }

            if (null != comp.getPlayerSign()) {
                switch (comp.getPlayerSign()) {
                    case "AT_SIGN":
                        returnPlayerSign = comp.getPlayerSign();
                        return returnPlayerSign;
                    case "HASH_SIGN":
                        returnPlayerSign = comp.getPlayerSign();
                        return returnPlayerSign;
                    case "H_SIGN":
                        returnPlayerSign = comp.getPlayerSign();
                        return returnPlayerSign;
                    default:
                        break;
                }
            }
        }
        return returnPlayerSign;
    }

    public boolean checkActivePlayer1HaveSign() {
        return (player1.getPlayerSign() != "N") && ((comp.getPlayerSign() != "N") || (player2.getPlayerSign() != "N"));
    }

    public boolean checkActivePlayer2HaveSign() {
        return (player2.getPlayerSign() != "N") && ((comp.getPlayerSign() != "N") || (player1.getPlayerSign() != "N"));
    }

    public void trigglePlayer1SignButton() {
        groupPlayer1Signs = new ToggleGroup();

        if (null != fireSign) {
            switch (fireSign) {
                case "K01":
                    player1.setPlayerSign("X_SIGN");

                    return;
                case "K02":
                    player1.setPlayerSign("O_SIGN");

                    return;
                case "K03":
                    player1.setPlayerSign("T_SIGN");

                    break;
                default:
                    break;
            }
        }
    }

    public void trigglePlayer2SignButton() {
        groupPlayer2Signs = new ToggleGroup();

        if (null != fireSign) {
            switch (fireSign) {
                case "K11":
                    player2.setPlayerSign("PLUS_SIGN");

                    return;
                case "K12":
                    player2.setPlayerSign("Q_SIGN");

                    return;
                case "K13":
                    player2.setPlayerSign("V_SIGN");

                    break;
                default:
                    break;
            }
        }
    }

    public void triggleCompSignButton() {
        groupCompSign = new ToggleGroup();

        if (null != fireSign) {
            switch (fireSign) {
                case "K21":
                    comp.setPlayerSign("HASH_SIGN");

                    return;
                case "K22":
                    comp.setPlayerSign("AT_SIGN");

                    return;
                case "K23":
                    comp.setPlayerSign("H_SIGN");

                    break;
                default:
                    break;
            }
        }
    }

    public void initPlayer1() {
        player1 = new Player();
        if (checkNullToogleForComp() != true || checkNullToogleForPl2() != true) {
            player1.setPlayerQueue(PlayerQueue.SECOND.toString());
        } else {
            player1.setPlayerQueue(PlayerQueue.FIRST.toString());
        }

        groupPlayer1 = new ToggleGroup();
        player1.setPlayerName(PlayerName.PLAYER1.toString());
        player1.setPlayerState(PlayerState.IN_GAME.toString());
        player1.setPlayerTurn(PlayerTurn.P_START.toString());

    }

    public void initComp() {
        comp = new Player();
        if (checkNullToogleForPl1() != true || checkNullToogleForPl2() != true) {
            comp.setPlayerQueue(PlayerQueue.SECOND.toString());
        } else {
            comp.setPlayerQueue(PlayerQueue.FIRST.toString());
        }
        groupComp = new ToggleGroup();
        comp.setPlayerName(PlayerName.COMP.toString());
        comp.setPlayerState(PlayerState.IN_GAME.toString());
        comp.setPlayerTurn(PlayerTurn.P_START.toString());

    }

    public void initPlayer2() {
        player2 = new Player();
        if (checkNullToogleForComp() != true || checkNullToogleForPl1() != true) {
            player2.setPlayerQueue(PlayerQueue.SECOND.toString());
        } else {
            player2.setPlayerQueue(PlayerQueue.FIRST.toString());
        }

        groupPlayer2 = new ToggleGroup();
        player2.setPlayerName(PlayerName.PLAYER2.toString());
        player2.setPlayerState(PlayerState.IN_GAME.toString());
        player2.setPlayerTurn(PlayerTurn.P_START.toString());

    }

    public boolean checkThreeInRow() {
        sumPlayersRow0 = 0;
        sumPlayersRow1 = 0;
        sumPlayersRow2 = 0;
        sumPlayersCol0 = 0;
        sumPlayersCol1 = 0;
        sumPlayersCol2 = 0;
        sumPlayersDiagF = 0;
        sumPlayersDiagB = 0;

        for (int j = 0; j < 3; j++) {
            int row0 = CellArr[0][j].getWeightNumPlayers();
            int row1 = CellArr[1][j].getWeightNumPlayers();
            int row2 = CellArr[2][j].getWeightNumPlayers();
            sumPlayersRow0 = sumPlayersRow0 + row0;
            sumPlayersRow1 = sumPlayersRow1 + row1;
            sumPlayersRow2 = sumPlayersRow2 + row2;

            if (sumPlayersRow0 == 15 || sumPlayersRow0 == 60 || sumPlayersRow0 == 300) {
                return true;
            }

            if (sumPlayersRow1 == 15 || sumPlayersRow1 == 60 || sumPlayersRow1 == 300) {
                return true;
            }

            if (sumPlayersRow2 == 15 || sumPlayersRow2 == 60 || sumPlayersRow2 == 300) {
                return true;
            }
        }

        for (int i = 0; i < 3; i++) {
            int col0 = CellArr[i][0].getWeightNumPlayers();
            int col1 = CellArr[i][1].getWeightNumPlayers();
            int col2 = CellArr[i][2].getWeightNumPlayers();
            sumPlayersCol0 = sumPlayersCol0 + col0;
            sumPlayersCol1 = sumPlayersCol1 + col1;
            sumPlayersCol2 = sumPlayersCol2 + col2;

            if (sumPlayersCol0 == 15 || sumPlayersCol0 == 60 || sumPlayersCol0 == 300) {
                return true;
            }

            if (sumPlayersCol1 == 15 || sumPlayersCol1 == 60 || sumPlayersCol1 == 300) {
                return true;
            }

            if (sumPlayersCol2 == 15 || sumPlayersCol2 == 60 || sumPlayersCol2 == 300) {

                return true;
            }

        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == j) {

                    int diagf = CellArr[i][j].getWeightNumPlayers();
                    sumPlayersDiagF = sumPlayersDiagF + diagf;

                    if (sumPlayersDiagF == 15 || sumPlayersDiagF == 60 || sumPlayersDiagF == 300) {
                        return true;
                    }
                }

                if ((i == 0 && j == 2) || (i == 1 && j == 1) || (i == 2 && j == 0)) {
                    int diagb = CellArr[i][j].getWeightNumPlayers();
                    sumPlayersDiagB = sumPlayersDiagB + diagb;
                    if (sumPlayersDiagB == 15 || sumPlayersDiagB == 60 || sumPlayersDiagB == 300) {
                        return true;
                    }
                }

            }
        }
        return false;

    }

    public boolean checkTwoInRow() {
        sumPlayersRow0 = 0;
        sumPlayersRow1 = 0;
        sumPlayersRow2 = 0;
        sumPlayersCol0 = 0;
        sumPlayersCol1 = 0;
        sumPlayersCol2 = 0;
        sumPlayersDiagF = 0;
        sumPlayersDiagB = 0;

        for (int j = 0; j < 3; j++) {
            int row0 = CellArr[0][j].getWeightNumPlayers();
            int row1 = CellArr[1][j].getWeightNumPlayers();
            int row2 = CellArr[2][j].getWeightNumPlayers();
            sumPlayersRow0 = sumPlayersRow0 + row0;
            sumPlayersRow1 = sumPlayersRow1 + row1;
            sumPlayersRow2 = sumPlayersRow2 + row2;

            if (sumPlayersRow0 == 10 || sumPlayersRow0 == 40 || sumPlayersRow0 == 200) {
                return true;
            }

            if (sumPlayersRow1 == 10 || sumPlayersRow1 == 40 || sumPlayersRow1 == 200) {
                return true;
            }

            if (sumPlayersRow2 == 10 || sumPlayersRow2 == 40 || sumPlayersRow2 == 200) {
                return true;
            }
        }

        for (int i = 0; i < 3; i++) {
            int col0 = CellArr[i][0].getWeightNumPlayers();
            int col1 = CellArr[i][1].getWeightNumPlayers();
            int col2 = CellArr[i][2].getWeightNumPlayers();
            sumPlayersCol0 = sumPlayersCol0 + col0;
            sumPlayersCol1 = sumPlayersCol1 + col1;
            sumPlayersCol2 = sumPlayersCol2 + col2;

            if (sumPlayersCol0 == 10 || sumPlayersCol0 == 40 || sumPlayersCol0 == 200) {
                return true;
            }

            if (sumPlayersCol1 == 10 || sumPlayersCol1 == 40 || sumPlayersCol1 == 200) {
                return true;
            }

            if (sumPlayersCol2 == 10 || sumPlayersCol2 == 40 || sumPlayersCol2 == 200) {
                return true;
            }

        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == j) {

                    int diagf = CellArr[i][j].getWeightNumPlayers();
                    sumPlayersDiagF = sumPlayersDiagF + diagf;

                    if (sumPlayersDiagF == 10 || sumPlayersDiagF == 40 || sumPlayersDiagF == 200) {
                        return true;
                    }
                }

                if ((i == 0 && j == 2) || (i == 1 && j == 1) || (i == 2 && j == 0)) {
                    int diagb = CellArr[i][j].getWeightNumPlayers();
                    sumPlayersDiagB = sumPlayersDiagB + diagb;
                    if (sumPlayersDiagB == 10 || sumPlayersDiagB == 40 || sumPlayersDiagB == 200) {
                        return true;
                    }
                }

            }
        }
        return false;

    }

    public boolean checkTwoInRow0Player() {
        sumPlayersRow0 = 0;
        for (int j = 0; j < 3; j++) {
            int row0 = CellArr[0][j].getWeightNumPlayers();
            sumPlayersRow0 = sumPlayersRow0 + row0;

            if (sumPlayersRow0 == 10 || sumPlayersRow0 == 40) {
                return true;
            }
        }
        return false;

    }

    public boolean checkTwoInRow1Player() {
        sumPlayersRow1 = 0;
        for (int j = 0; j < 3; j++) {
            int row1 = CellArr[1][j].getWeightNumPlayers();
            sumPlayersRow1 = sumPlayersRow1 + row1;

            if (sumPlayersRow1 == 10 || sumPlayersRow1 == 40) {
                return true;
            }
        }
        return false;

    }

    public boolean checkTwoInRow2Player() {
        sumPlayersRow2 = 0;
        for (int j = 0; j < 3; j++) {
            int row2 = CellArr[2][j].getWeightNumPlayers();
            sumPlayersRow2 = sumPlayersRow2 + row2;

            if (sumPlayersRow2 == 10 || sumPlayersRow2 == 40) {
                return true;
            }
        }
        return false;

    }

    public boolean checkTwoInCol0Player() {
        sumPlayersCol0 = 0;
        for (int i = 0; i < 3; i++) {
            int col0 = CellArr[i][0].getWeightNumPlayers();
            sumPlayersCol0 = sumPlayersCol0 + col0;
            if (sumPlayersCol0 == 10 || sumPlayersCol0 == 40) {
                return true;
            }

        }
        return false;

    }

    public boolean checkTwoInCol1Player() {
        sumPlayersCol1 = 0;
        for (int i = 0; i < 3; i++) {
            int col1 = CellArr[i][1].getWeightNumPlayers();
            sumPlayersCol1 = sumPlayersCol1 + col1;
            if (sumPlayersCol1 == 10 || sumPlayersCol1 == 40) {
                return true;
            }

        }
        return false;

    }

    public boolean checkTwoInCol2Player() {
        sumPlayersCol2 = 0;
        for (int i = 0; i < 3; i++) {
            int col2 = CellArr[i][2].getWeightNumPlayers();
            sumPlayersCol2 = sumPlayersCol2 + col2;
            if (sumPlayersCol2 == 10 || sumPlayersCol2 == 40) {
                return true;
            }

        }
        return false;

    }

    public boolean checkTwoInDiagfPlayer() {
        sumPlayersDiagF = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == j) {
                    int diagf = CellArr[i][j].getWeightNumPlayers();
                    sumPlayersDiagF = sumPlayersDiagF + diagf;

                    if (sumPlayersDiagF == 10 || sumPlayersDiagF == 40) {
                        return true;
                    }
                }

            }
        }

        return false;

    }

    public boolean checkTwoInDiagbPlayer() {
        sumPlayersDiagB = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if ((i == 0 && j == 2) || (i == 1 && j == 1) || (i == 2 && j == 0)) {
                    int diagb = CellArr[i][j].getWeightNumPlayers();
                    sumPlayersDiagB = sumPlayersDiagB + diagb;
                    if (sumPlayersDiagB == 10 || sumPlayersDiagB == 40) {
                        return true;
                    }
                }

            }
        }

        return false;

    }

    public boolean checkTwoInRow0Comp() {
        sumPlayersRow0 = 0;
        for (int j = 0; j < 3; j++) {
            int row0 = CellArr[0][j].getWeightNumPlayers();
            sumPlayersRow0 = sumPlayersRow0 + row0;

            if (sumPlayersRow0 == 200) {
                return true;
            }
        }
        return false;

    }

    public boolean checkTwoInRow1Comp() {
        sumPlayersRow1 = 0;
        for (int j = 0; j < 3; j++) {
            int row1 = CellArr[1][j].getWeightNumPlayers();
            sumPlayersRow1 = sumPlayersRow1 + row1;

            if (sumPlayersRow1 == 200) {
                return true;
            }
        }
        return false;

    }

    public boolean checkTwoInRow2Comp() {
        sumPlayersRow2 = 0;
        for (int j = 0; j < 3; j++) {
            int row2 = CellArr[2][j].getWeightNumPlayers();
            sumPlayersRow2 = sumPlayersRow2 + row2;

            if (sumPlayersRow2 == 200) {
                return true;
            }
        }
        return false;

    }

    public boolean checkTwoInCol0Comp() {
        sumPlayersCol0 = 0;
        for (int i = 0; i < 3; i++) {
            int col0 = CellArr[i][0].getWeightNumPlayers();
            sumPlayersCol0 = sumPlayersCol0 + col0;
            if (sumPlayersCol0 == 200) {
                return true;
            }

        }
        return false;

    }

    public boolean checkTwoInCol1Comp() {
        sumPlayersCol1 = 0;
        for (int i = 0; i < 3; i++) {
            int col1 = CellArr[i][1].getWeightNumPlayers();
            sumPlayersCol1 = sumPlayersCol1 + col1;
            if (sumPlayersCol1 == 200) {
                return true;
            }

        }
        return false;

    }

    public boolean checkTwoInCol2Comp() {
        sumPlayersCol2 = 0;
        for (int i = 0; i < 3; i++) {
            int col2 = CellArr[i][2].getWeightNumPlayers();
            sumPlayersCol2 = sumPlayersCol2 + col2;
            if (sumPlayersCol2 == 200) {
                return true;
            }

        }
        return false;

    }

    public boolean checkTwoInDiagfComp() {
        sumPlayersDiagF = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == j) {
                    int diagf = CellArr[i][j].getWeightNumPlayers();
                    sumPlayersDiagF = sumPlayersDiagF + diagf;

                    if (sumPlayersDiagF == 200) {
                        return true;
                    }
                }

            }
        }

        return false;

    }

    public boolean checkTwoInDiagbComp() {
        sumPlayersDiagB = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if ((i == 0 && j == 2) || (i == 1 && j == 1) || (i == 2 && j == 0)) {
                    int diagb = CellArr[i][j].getWeightNumPlayers();
                    sumPlayersDiagB = sumPlayersDiagB + diagb;
                    if (sumPlayersDiagB == 200) {
                        return true;
                    }
                }

            }
        }

        return false;

    }

    public void checkWhowWins() {
        winPlayer1 = false;
        winPlayer2 = false;
        winComp = false;
        if (sumPlayersRow0 == 15
                || sumPlayersRow1 == 15
                || sumPlayersRow2 == 15
                || sumPlayersCol0 == 15
                || sumPlayersCol1 == 15
                || sumPlayersCol2 == 15
                || sumPlayersDiagF == 15
                || sumPlayersDiagB == 15) {
            sumWinPlayer1 = sumWinPlayer1 + 1;

            winPlayer1 = true;
            winPlayer2 = false;
            winComp = false;
        }

        if (sumPlayersRow0 == 60
                || sumPlayersRow1 == 60
                || sumPlayersRow2 == 60
                || sumPlayersCol0 == 60
                || sumPlayersCol1 == 60
                || sumPlayersCol2 == 60
                || sumPlayersDiagF == 60
                || sumPlayersDiagB == 60) {
            sumWinPlayer2 = sumWinPlayer2 + 1;

            winPlayer1 = false;
            winPlayer2 = true;
            winComp = false;
        }

        if (sumPlayersRow0 == 300
                || sumPlayersRow1 == 300
                || sumPlayersRow2 == 300
                || sumPlayersCol0 == 300
                || sumPlayersCol1 == 300
                || sumPlayersCol2 == 300
                || sumPlayersDiagF == 300
                || sumPlayersDiagB == 300) {
            sumWinComp = sumWinComp + 1;

            winPlayer1 = false;
            winPlayer2 = false;
            winComp = true;
        }

    }

    public String getToString2(int a) {
        String b = Integer.toString(a);
        return b;
    }
/**
 *
 * @author Jacek Byzdra
 * email: jacekbwwa@gmail.com
 */
}
