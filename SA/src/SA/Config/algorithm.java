package SA.Config;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

//算法类
public class algorithm {


    public algorithm() {
    }

    /* 字符串启动对应方法
     * 使用方法：输入方法名字符串，启动该方法
     * 函数功能：启动字符串对应方法（）
     *
    public void do_not_close( String s){
            try {
                Do_Not_Close home=new Do_Not_Close();
                Class cla=home.getClass();
                Method m=cla.getDeclaredMethod(s);
                m.invoke(home);
            } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                e.printStackTrace();
            }
    }
*/

    /**
     * 输入  double 难度，String 年级,返回String 数组  10道题 名称
     *
     * @param nandu
     * @param nianji
     * @return
     */
    public String[] ChuTi(double nandu, String nianji) {
        algorithm suanfa = new algorithm();

        File file = new File("question_bank/" + nianji);
        String[] fileName = file.list();
        String[] x, y;
        double[][] n = new double[fileName.length][3];
        for (int q = 0; q < fileName.length; q++) {
            x = fileName[q].split("\\.");
            y = (x[0] + "." + x[1]).split("-");
            for (int m = 0; m < 3; m++)
                n[q][m] = Double.parseDouble(y[m]);
        }

        double[][] n22 = suanfa.QuickSort(n, 1, 0, fileName.length - 1);

        int[][] fanwei = new int[4][2];//分为4段取值挑题

        //题目名称存储位置
        String[] jieguo = new String[10];

        //算法内容：以适应难度为中线，取上下10题，2题低1难度，4题趋近难度(上下0.5)，2题高0.5难度，2题高1难度
        for (int q = 0; q < fileName.length; q++) {
            if (nandu - 1.5 >= 1) {

                if (nandu + 1.5 >= 10) {
                    //难度为10

                    //简单分段
                    if (n22[q][1] > 8 && fanwei[0][0] == 0) {
                        fanwei[0][0] = q;
                    } else if (n22[q][1] >= 8.5 && fanwei[0][1] == 0) {
                        fanwei[0][1] = q;
                    }

                    //普通分段
                    else if (n22[q][1] > 8.5 && fanwei[1][0] == 0) {
                        fanwei[1][0] = q;
                    } else if (n22[q][1] >= 9 && fanwei[1][1] == 0) {
                        fanwei[1][1] = q;
                    }

                    //较难片段
                    else if (n22[q][1] > 9 && fanwei[2][0] == 0) {
                        fanwei[2][0] = q;
                    } else if (n22[q][1] >= 9.5 && fanwei[2][1] == 0) {
                        fanwei[2][1] = q;
                    }

                    //挑战片段
                    else if (n22[q][1] > 9.5 && fanwei[3][0] == 0) {
                        fanwei[3][0] = q;
                        fanwei[3][1] = fileName.length - 1;
                        break;
                    }

                } else {
                    //正常难度

                    //简单分段
                    if (n22[q][1] > nandu - 1.5 && fanwei[0][0] == 0) {
                        fanwei[0][0] = q;
                    } else if (n22[q][1] >= nandu - 0.5 && fanwei[0][1] == 0) {
                        fanwei[0][1] = q;
                    }

                    //普通分段
                    else if (n22[q][1] > nandu - 0.5 && fanwei[1][0] == 0) {
                        fanwei[1][0] = q;
                    } else if (n22[q][1] >= nandu + 0.5 && fanwei[1][1] == 0) {
                        fanwei[1][1] = q;
                    }

                    //较难片段
                    else if (n22[q][1] > nandu + 0.5 && fanwei[2][0] == 0) {
                        fanwei[2][0] = q;
                    } else if (n22[q][1] >= nandu + 1 && fanwei[2][1] == 0) {
                        fanwei[2][1] = q;
                    }

                    //挑战片段
                    else if (n22[q][1] > nandu + 1 && fanwei[3][0] == 0) {
                        fanwei[3][0] = q;
                    } else if (n22[q][1] >= nandu + 2 && fanwei[3][1] == 0) {
                        fanwei[3][1] = q;
                        break;
                    }

                }

            } else {
                //难度为1

                //简单分段
                if (n22[q][1] >= 1 && fanwei[0][0] == 0) {
                    fanwei[0][0] = q;
                } else if (n22[q][1] >= 1.5 && fanwei[0][1] == 0) {
                    fanwei[0][1] = q;
                }

                //普通分段
                else if (n22[q][1] > 1.5 && fanwei[1][0] == 0) {
                    fanwei[1][0] = q;
                } else if (n22[q][1] >= 3 && fanwei[1][1] == 0) {
                    fanwei[1][1] = q;
                }

                //较难片段
                else if (n22[q][1] > 3 && fanwei[2][0] == 0) {
                    fanwei[2][0] = q;
                } else if (n22[q][1] >= 3.5 && fanwei[2][1] == 0) {
                    fanwei[2][1] = q;
                }

                //挑战片段
                else if (n22[q][1] > 3.5 && fanwei[3][0] == 0) {
                    fanwei[3][0] = q;
                } else if (n22[q][1] >= 4.5 && fanwei[3][1] == 0) {
                    fanwei[3][1] = q;
                    break;
                }

            }

        }

        //再从范围里随机数挑题目
        for (int a = 0, b = 0, c = fanwei[0][0], la = 0, ji = 0, laji1, laji2; a < 10; a++) {

            la = ((int) (Math.random() * 1000)) % ((fanwei[b][1] - fanwei[b][0]) / 2);
            if (la == 0) {
                if (ji == 0 && c == fanwei[b][0])
                    ji = 1;
                else
                    while (la == 0) {
                        la = ((int) (Math.random() * 1000)) % ((fanwei[b][1] - fanwei[b][0]) / 2);
                    }
            }
            c += la;

            if (a >= 2 && a <= 5) {
                //取4题

                laji1 = (int) n22[c][1];
                laji2 = (int) (n22[c][1] * 10 - laji1 * 10);

                jieguo[a] = (int) n22[c][0] + "-" + laji1 + "." + laji2 + "-" + (int) n22[c][2] + ".txt";

                if (a == 5) {
                    b++;
                    c = fanwei[2][0];
                    ji = 0;
                }

            } else {
                //取2题

                laji1 = (int) n22[c][1];
                laji2 = (int) (n22[c][1] * 10 - laji1 * 10);

                jieguo[a] = (int) n22[c][0] + "-" + laji1 + "." + laji2 + "-" + (int) n22[c][2] + ".txt";

                if (a == 1) {
                    b++;
                    c = fanwei[1][0];
                    ji = 0;
                } else if (a == 7) {
                    b++;
                    c = fanwei[3][0];
                    ji = 0;
                }

            }
        }

        for (int a = 0; a < 10; a++) {
            System.out.println("【" + jieguo[a] + "  ");
        }

        return jieguo;
    }


    public int[] RealDaAn(String[] timu) {

        int[] n = new int[timu.length];
        String[] x, y;

        for (int q = 0; q < timu.length; q++) {
            x = timu[q].split("\\.");
            y = (x[0] + "." + x[1]).split("-");

            n[q] = Integer.parseInt(y[2]);

        }

        return n;
    }


    /**
     * 一键生成题库
     *
     * @throws IOException
     */
    public void yijiantiku() throws IOException {
        File file;
        FileWriter f;
        BufferedWriter fw;
        int y, x1, x2;
        double x;
        for (y = 1, x = 1.0; y <= 100; x += 0.1, y++) {

            x1 = (int) x;
            x2 = (int) (x * 10 - x1 * 10);

            file = new File("question_bank/2/" + y + "-" + x1 + "." + x2 + "-" + (y % 4 + 1) + ".txt");
            f = new FileWriter(file, false);
            fw = new BufferedWriter(f);

            if (!file.exists())
                file.createNewFile();

            fw.write("答案是" + (y % 4 + 1));
            fw.flush();
            fw.close();
            f.close();
        }
    }


    /* 快速排序
     * 使用方法：QuickSort(二维浮点型数组，纵坐标，0，该数组长度-1)
     * 函数功能：将目标数组快速排序，结果存回该数组
     * */
    public double[][] QuickSort(double[][] a, int where, int low, int high) {
        int start = low;
        int end = high;
        double key = a[low][where];

        /*从后往前比较*/
        while (end > start) {

            /*如果没有比关键值小的，比较下一个，直到有比关键值小的交换位置，然后又从前往后比较*/
            while (end > start && a[end][where] >= key)
                end--;
            if (a[end][where] <= key) {
                double[] temp = a[end];
                a[end] = a[start];
                a[start] = temp;
            }

            /*从前往后比较，如果没有比关键值大的，比较下一个，直到有比关键值大的交换位置*/
            while (end > start && a[start][where] <= key)
                start++;
            if (a[start][where] >= key) {
                double[] temp = a[start];
                a[start] = a[end];
                a[end] = temp;
            }

        }//此时第一次循环比较结束，关键值的位置已经确定了。左边的值都比关键值小，右边的值都比关键值大，但是两边的顺序还有可能是不一样的，进行下面的递归调用
        //递归
        if (start > low)
            QuickSort(a, where, low, start - 1);//左边序列。第一个索引位置到关键值索引-1
        if (end < high)
            QuickSort(a, where, end + 1, high);//右边序列。从关键值索引+1到最后一个

        return a;
    }


    /**
     * 二分查找
     *
     * @param arr      要进行查找的数组，要求数组必须是有序的
     * @param findElem 要查找的元素
     * @return 返回要查找的元素在数组的索引位置， 返回-1表示没找到
     */
    public int binarySearch(int[] arr, int findElem) {
        int low = 0;
        int high = arr.length - 1;
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            //如果要查找的元素findElem小于中间位置的元素mid，指向数组的较大端的high索引重新指向中间索引mid的左边（mid-1）
            if (findElem < arr[mid]) {
                high = mid - 1;
            }
            //如果要查找的元素findElem大于中间位置的元素mid，指向数组的较小端的low索引重新指向中间索引mid的右边（mid+1）
            if (findElem > arr[mid]) {
                low = mid + 1;
            }
            if (arr[mid] == findElem) {
                return mid;
            }
        }
        return -1;
    }


    //测试服务端是否可连通
    private static boolean isRunning(String host, int port) {
        Socket sClient = null;
        try {
            SocketAddress saAdd = new InetSocketAddress(host.trim(), port);
            sClient = new Socket();
            sClient.connect(saAdd, 5000);
        } catch (Exception e) {
            return false;
        } finally {
            try {
                if (sClient != null) {
                    sClient.close();
                }
            } catch (Exception e) {
            }
        }
        return true;
    }


}

