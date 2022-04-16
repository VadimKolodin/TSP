import controllers.Controller;
import dao.UserDao;
import dto.User;
import dto.UserInfo;


import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class main {
    public static void main(String[] args) {
        String text = "Мы вступаем в век, в котором образование, знания будут играть " +
                "определяющую роль в судьбе человека. Без знаний, кстати сказать, всё " +
                "усложняющихся, просто нельзя будет работать. Ибо физический труд " +
                "возьмут на себя машины. Даже вычисления будут делаться " +
                "компьютерами, так же, как чертежи, расчёты, отчёты, планирование. " +
                "Человек будет вносить новые идеи, думать над тем, над чем не сможет " +
                "думать машина. А для этого всё больше нужны будут общая " +
                "интеллигентность человека, его способность создавать новое и, " +
                "конечно, нравственная ответственность";
        HashMap<Character, Integer> count = new HashMap<>();
        int all = 0;
        for (char c: text.toCharArray()){
            if (count.containsKey(c)){
                int temp = count.get(c)+1;
                count.replace(c, temp);
            } else {
                count.put(c, 1);
            }
            ++all;
        }

        HashMap<Character, Double> pr = new HashMap<>();
        for (Map.Entry<Character, Integer> cur: count.entrySet()){
            //System.out.println(cur.getKey()+" "+cur.getValue());
            pr.put(cur.getKey(),(((double)cur.getValue())/all));
        }
        double entropy = 0;
        for (Map.Entry<Character, Double> cur: pr.entrySet()){
            entropy -=cur.getValue()*Math.log(cur.getValue())/Math.log(2);
        }
        System.out.println("Энтропия: "+entropy+" Граница Шеннона: "+(entropy*Math.log(2)/Math.log(34)));
        HashMap<Character, String> codes= new HashMap<>();
        codes.put(' ',"0000");
        codes.put('е',"0001");
        codes.put('т',"0010");
        codes.put('о',"0011");
        codes.put('а',"0100");
        codes.put('н',"0101");
        codes.put('с',"0110");
        codes.put('и',"0111");
        codes.put('в',"10000");
        codes.put('у',"10001");
        codes.put('ь',"10010");
        codes.put('д',"10011");
        codes.put(',',"10100");
        codes.put('л',"10101");
        codes.put('р',"10110");
        codes.put('к',"10111");
        codes.put('б',"110000");
        codes.put('м',"110001");
        codes.put('я',"110010");
        codes.put('з',"110011");
        codes.put('ч',"110100");
        codes.put('ы',"110101");
        codes.put('ж',"110110");
        codes.put('п',"110111");
        codes.put('.',"111000");
        codes.put('ю',"111001");
        codes.put('г',"111010");
        codes.put('ё',"111011");
        codes.put('ш',"111100");
        codes.put('щ',"1111010");
        codes.put('й',"11110110");
        codes.put('ф',"11110111");
        codes.put('х',"11111000");
        codes.put('э',"11111001");
        codes.put('А',"11111010");
        codes.put('Б',"11111011");
        codes.put('Д',"11111100");
        codes.put('И',"11111101");
        codes.put('М',"11111110");
        codes.put('Ч',"11111111");
        double average=0;
        for (Map.Entry<Character, Double> cur: pr.entrySet()){
            average +=cur.getValue()*codes.get(cur.getKey()).length();
        }
        System.out.println("Средняя длина: " + average);
        int temp =0;
        for (char c: text.toCharArray()){
            try {
                System.out.print(codes.get(c));
                temp += codes.get(c).length();
                if (temp >= 100) {
                    System.out.println();
                    temp = 0;
                }
            }catch(Exception e){
                System.out.println(c);
            }
        }

    }
}
