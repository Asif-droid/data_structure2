package offline5;

import java.util.LinkedList;
import java.util.Random;

public class Hash {

    int n;

    Hash(){

    }

    int pset[] ={1009, 1013, 1019, 1021, 1031, 1033, 1039, 1049, 1051, 1061, 1063, 1069, 1087,
            1091, 1093, 1097, 1103, 1109, 1117, 1123, 1129, 1151, 1153, 1163, 1171, 1181,
            1187, 1193, 1201, 1213, 1217, 1223, 1229, 1231, 1237, 1249, 1259, 1277, 1279,
            1283, 1289, 1291, 1297, 1301, 1303, 1307, 1319, 1321, 1327, 1361, 1367, 1373,
            1381, 1399, 1409, 1423, 1427, 1429, 1433, 1439, 1447, 1451, 1453, 1459, 1471,
            1481, 1483, 1487, 1489, 1493, 1499, 1511, 1523, 1531, 1543, 1549, 1553, 1559,
            1567, 1571, 1579, 1583, 1597, 1601, 1607, 1609, 1613, 1619, 1621, 1627, 1637,
            1657, 1663, 1667, 1669, 1693, 1697, 1699, 1709, 1721, 1723, 1733, 1741, 1747,
            1753, 1759, 1777, 1783, 1787, 1789, 1801, 1811, 1823, 1831, 1847, 1861, 1867,
            1871, 1873, 1877, 1879, 1889, 1901, 1907, 1913, 1931, 1933, 1949, 1951, 1973,
            1979, 1987, 1993, 1997, 1999, 2003, 2011, 2017, 2027, 2029, 2039, 2053, 2063,
            2069, 2081, 2083, 2087, 2089, 2099, 2111, 2113, 2129, 2131, 2137, 2141, 2143,
            2153, 2161, 2179, 2203, 2207, 2213, 2221, 2237, 2239, 2243, 2251, 2267, 2269,
            2273, 2281, 2287, 2293, 2297, 2309, 2311, 2333, 2339, 2341, 2347, 2351, 2357};




    Hash(int n){
        this.n=n;


    }
    int h1(String key){
        int k=0;
        int p=1;
        for(int i=0;i<key.length();i++){
            k+=key.charAt(i)-'a';
            p*=(pset[(k+7)%(pset.length)]);
        }
        p=Math.abs(p);
        return (p)%n;
    }

    int h2(String key){
        int k=0;
        long  p=1;
        for(int i=0;i<key.length();i++){
            k+=key.charAt(i)-'a';
            p*=pset[k%(pset.length)];

        }

        p%=n;
        p=Math.abs(p);
        //System.out.println(p);


        return (int)p ;
    }

    int auxh(String key){
        int k=0;
        int p=1;
        for(int i=0;i<key.length();i++){
            k=(key.charAt(i)-'a');

            p*=k;
        }

        p%=n;
        p=Math.abs(p);
        return p;
    }



    public static void main(String[] args) {
        /*Random rnd=new Random();
        Hash h=new Hash(10);
        for(int i=0;i<7;i++){
            String key="";
            for(int j=0;j<7;j++){
                int r=rnd.nextInt(25)+'a';
                key+=(char)r;
            }
            System.out.println(key+" "+h.insert1(key));
        }
        System.out.println("djab");
        h.show();
*/

    }



}
