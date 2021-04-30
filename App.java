package task;

public class App {

    /**
     * проверяем строку на вложенность вида 2[3[x]y]
     */
    public void checkString(String in) {
        StringBuilder str = new StringBuilder();
        char[] chars = in.toCharArray();
        for (Character ch : chars) {
            if (ch.equals('[')) {
                str.append(ch);
            }
            if (ch.equals(']')) {
                str = new StringBuilder();
            }
            if (str.toString().equals("[[")) {
                inversionString(in);
                break;
            }
        }

        if (str.toString().equals("")) {
            parseString(in);
        }
    }

    /**
     * с вложенными повторениями в строке,
     * вида 2[3[x]y]
     */
    private void inversionString(String strIn) {

        char[] chars = strIn.toCharArray();
        boolean inner = false;
        boolean outer = false;
        int ind = 0;
        int num = 0;
        String letters = "";
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];

//внешняя открывающаяся скобка
            if (ch == '[' && !outer) {
                ind = i;
                String str = strIn.substring(i - 1, i + 1);
                result.append(str);
                outer = true;
                continue;
            }

//внутренняя открывающая скобка
            if (ch == '[') {

                String str = strIn.substring(ind + 1, i);
                ind = i;
                num = Integer.parseInt(str);
                inner = true;
                continue;
            }

//внутренняя закрывающая скобка
            if (ch == ']' && outer && inner) {

                letters = strIn.substring(ind + 1, i);
                ind = i;

                for (int j = 0; j < num; j++) {
                    result.append(letters);
                }
                inner = false;
                continue;
            }

//внешняя закрывающая скобка
            if (ch == ']') {

                letters = strIn.substring(ind + 1, i + 1);
                result.append(letters);
                outer = false;
            }
        }
        parseString(result.toString());
    }

    /**
     * без вложенных повторений в строке,
     * вида 3[xyz]4[xy]z
     */
    private void parseString(String strOut) {

        String temp = "";
        StringBuilder digit = new StringBuilder("0");
        String letters = "";
        StringBuilder result = new StringBuilder();
        int num = 0;

        String[] strArr = strOut.split("]");

        for (String s : strArr) {
            temp = s;
            for (char ch : temp.toCharArray()) {
                if (Character.isDigit(ch)) {
                    digit.append(ch);
                }
                if (Character.isLetter(ch)) {
                    letters += ch;
                }
            }
            num = Integer.parseInt(digit.toString());
            if (num == 0) num = 1;
            digit = new StringBuilder("0");

            for (int j = 0; j < num; j++) {
                result.append(letters);
            }
            letters = "";
        }
        System.out.println(result);
    }
}