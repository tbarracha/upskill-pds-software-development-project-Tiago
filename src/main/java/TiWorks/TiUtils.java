package TiWorks;

import pt.org.upskill.ui.utils.Utils;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Tiago Barracha ti.barracha@gmail.com
 *
 * @Usage Methods are organized into static subclasses.
 * @Example Call them like this:
 * <pre>
 *     int input = TiUtils.ConsoleIn.readIntegerFromConsole("Insert option: ");
 *     var rand  = TiUtils.Randomizer.getRandomFromList(list);
 * </pre>
 */
public final class TiUtils {
    private static Random random = new Random();

    // arrays/vetores estáticos:
    static final String[] ALPHABET = {
            "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M",
            "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"
    };

    static final Boolean[] TRUE_OR_FALSE = { true, false };

    public static void print(String message) {
        System.out.println(message);
    }

    public static void print(String message, Object... params) {
        System.out.println(String.format(message, params));
    }

    // Usefull arrays and methods used in the UpSkill java course
    // ---------------------------------------------------------------------------------------------------------
    public static class UpSkill {
        static final String[] NOMES         = { "Vânia", "Humberto", "Tiago", "Rafa", "Anna", "Isa", "Clarissa", "Pedro", "Nuno", "Pedro", "Fransisco", "Solange", "Fábio", "Hugo", "Susana", "Tânia", "Wilson", "Sónia", "João" };
        static final String[] APELIDOS      = { "Delgado", "Barracha", "Silva", "Pereira", "Figueiredo", "Mota", "Costa", "Peixoto", "Brasão", "Vasconcelos", "Sarzedo", "Cabral" };
        static final String[] MORADAS       = { "Amarante", "Lisboa", "Porto", "Alcobaça", "Ovar", "Viseu", "Leiria", "Caldas da Rainha" };
        static final String[] EMPRESAS      = { "UpSkill", "Minsait", "Indra", "Critial", "Outsystems", "Microsoft", "Amazon", "Apple", "Google", "Facebook", "LinkedIn", "Twitter" };
        static final String[] PROFISSOES    = { "Programador", "Front-End Dev", "Back-End Dev", "Empresário", "Artista", "Professor", "Carpinteiro", "Cerralheiro", "Mecânico" };
        static final String[] CORES         = { "Vermelho", "Azul", "Verde", "Amarelo", "Laranja", "Roxo", "Rosa", "Cinza", "Preto", "Branco" };
        static final String[] NACIONALIDADES = { "Portuguesa", "Espanhola", "Francesa", "Italiana", "Alemã", "Inglesa", "Brasileira" };
        static final String[] EMAIL_PROVIDERS = { "gmail", "yahoo", "upskill", "hotmail", "outlook", "protonmail", "icloud", "aol", "mail", "zoho" };
        static final String[] DOMAIN_EXTENSIONS = { ".com", ".io", ".pt", ".net", ".org", ".edu", ".gov", ".info" };
        static final String[] EMAIL_SEPERATOR = { "", ".", "_" };

        public static String getRandomNome() { return Randomizer.getRandomFromArray(NOMES); }

        public static String getRandomApelido() {
            return Randomizer.getRandomFromArray(APELIDOS);
        }

        public static String getRandomNomeCompleto() {
            return String.format("%s %s", getRandomNome(), getRandomApelido());
        }

        public static String getRandomMorada() {
            return Randomizer.getRandomFromArray(MORADAS);
        }

        public static String getRandomEmpresa() {
            return Randomizer.getRandomFromArray(EMPRESAS);
        }

        public static String getRandomProfissao() {
            return Randomizer.getRandomFromArray(PROFISSOES);
        }

        public static String getRandomCor() {
            return Randomizer.getRandomFromArray(CORES);
        }

        public static String getRandomNacionalidade() { return Randomizer.getRandomFromArray(NACIONALIDADES); }

        public static int getRandomIdade(int min, int max) {
            return random.nextInt(min, max + 1);
        }

        public static String getRandomEmail() {
            return String.format("%s%s%s@%s%s", getRandomNome().toLowerCase().trim(), Randomizer.getRandomFromArray(EMAIL_SEPERATOR), getRandomApelido().toLowerCase().trim(), Randomizer.getRandomFromArray(EMAIL_PROVIDERS), Randomizer.getRandomFromArray(DOMAIN_EXTENSIONS));
        }

        public static String getRandomEmail(String name) {
            return String.format("%s@%s%s", name, Randomizer.getRandomFromArray(EMAIL_PROVIDERS), Randomizer.getRandomFromArray(DOMAIN_EXTENSIONS));
        }
    }



    public static class Lists {
        public static <T> boolean isIndexWithinBounds(T[] array, int index) {
            return index >= 0 && index < array.length;
        }

        public static <T> boolean isIndexWithinBounds(List<T> list, int index) {
            return index >= 0 && index < list.size();
        }


        /**
         * @Usage ArrayList< int > ints = getClassObjectsFromArray(array, Integer.class);
         */
        public static <T> List<T> getClassObjectsFromArray(Object[] array, Class<T> type) {
            ArrayList<T> result = new ArrayList<>();

            for (Object obj : array) {
                if (type.isInstance(obj)) {
                    result.add(type.cast(obj));
                }
            }

            return result;
        }

        /**
         * @Usage ArrayList< int > ints = getClassObjectsFromList(array, Integer.class);
         */
        public static <T> ArrayList<T> getClassObjectsFromList(List<Object> array, Class<T> type) {
            ArrayList<T> result = new ArrayList<>();

            for (Object obj : array) {
                if (type.isInstance(obj)) {
                    result.add(type.cast(obj));
                }
            }

            return result;
        }


        public static <T> boolean addToArray(T[] array, T... objs) {
            if (objs.length == 0) {
                System.out.println("No objects to add.");
                return false;
            }

            // Ensure the array is not null
            if (array == null) {
                System.out.println("Array is null.");
                return false;
            }

            // Calculate the new size of the array
            int newSize = array.length + objs.length;

            // Create a new array with the combined length
            T[] newArray = Arrays.copyOf(array, newSize);

            // Copy the elements from the original array and the new objects to the new array
            System.arraycopy(objs, 0, newArray, array.length, objs.length);

            // Update the reference to the new array
            array = newArray;

            return true;
        }

        public static <T> boolean addToList(List<T> list, T... objs) {
            if (objs.length == 0) {
                System.out.println("No objects to add.");
                return false;
            }

            if (list == null) {
                System.out.println("List is null.");
                return false;
            }

            list.addAll(List.of(objs));

            return true;
        }


        public static <T> T selectFromListOptions(List<T> list, String header, boolean forceUppercase) {
            ConsoleOut.printSubSubTitle(header, forceUppercase);

            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) != null) {
                    System.out.println(String.format("%d - %s", i, list.get(i)));
                }
            }

            do {
                int index = ConsoleIn.readIntegerFromConsole("Select Option: ");

                if (index == -1) {
                    System.out.println("Returning null/empty");
                    return null;
                }

                if (isIndexWithinBounds(list, index)) {
                    T selectedOption = list.get(index);
                    if (selectedOption != null) {
                        return selectedOption;
                    } else {
                        System.out.println("Selected option is null. Please select a valid option.");
                    }
                } else {
                    System.out.println("Invalid index. Please select a valid option.");
                }

            } while (true);
        }

        public static <T> T selectFromArrayOptions(T[] array, String header, boolean forceUppercase) {
            ConsoleOut.printSubSubTitle(header, forceUppercase);

            for (int i = 0; i < array.length; i++) {
                if (array[i] != null) {
                    System.out.println(String.format("%d - %s", i, array[i]));
                }
            }

            do {
                int index = ConsoleIn.readIntegerFromConsole("Select Option: ");

                if (isIndexWithinBounds(array, index)) {
                    T selectedOption = array[index];
                    if (selectedOption != null) {
                        return selectedOption;
                    } else {
                        System.out.println("Selected option is null. Please select a valid option.");
                    }
                } else {
                    System.out.println("Invalid index. Please select a valid option.");
                }

            } while (true);
        }
    }


    public static class Randomizer {
        public static <T> T getRandomFromArray(T[] array) {
            try {
                int index = random.nextInt(0, array.length);
                return array[index];
            } catch (Exception e) {
                System.out.println(String.format("Random from Array Error: %s", e.getMessage()));
                return null;
            }
        }

        public static <T> T getRandomFromList(List<T> list) {
            try {
                int index = random.nextInt(0, list.size());
                return list.get(index);
            } catch (Exception e) {
                System.out.println(String.format("Random from List Error: %s", e.getMessage()));
                return null;
            }
        }


        public static <T extends Enum<?>> T getRandomEnumValue(Class<T> enumClass) {
            T[] enumValues = enumClass.getEnumConstants();
            return enumValues[random.nextInt(enumValues.length)];
        }


        public static boolean getTrueOrFalse() {
            return getRandomFromArray(TRUE_OR_FALSE);
        }

        public static String getRandomAlphabetLetter() {
            return getRandomFromArray(ALPHABET);
        }

        public static String getRandomNumberString(int idLength) {
            String id = "";

            if (idLength <= 0)
                idLength = 12;

            for (int i = 0; i < idLength; i++) {
                id = String.format("%s%d", id, random.nextInt(10));
            }

            return id;
        }

        public static String getRandomAlphanumericString(int length) {
            StringBuilder stringBuilder = new StringBuilder();

            if (length < 0)
                length = 5;

            for (int i = 0; i < length; i++) {
                if (Randomizer.getTrueOrFalse()) {
                    stringBuilder.append(Randomizer.getRandomAlphabetLetter());
                } else {
                    stringBuilder.append(random.nextInt(0, 10));
                }
            }

            return stringBuilder.toString();
        }
    }



    // Console OUTPUT
    // ---------------------------------------------------------------------------------------------------------
    public static class ConsoleOut {
        //Ex:
        // ===============
        // === message ===
        // ===============
        public static String createTitle(String message) {
            String middlePart = "=== " + message + " ===";
            String border = "=".repeat(middlePart.length());
            return String.format("%s\n%s\n%s", border, middlePart, border);
        }

        //Ex:
        // ===============
        // === message ===
        // ===============
        public static String createTitle(String message, char borderChar) {
            String middleBorder = String.valueOf(borderChar).repeat(3);
            String middlePart = middleBorder + " " + message + " " + middleBorder;
            String border = String.valueOf(borderChar).repeat(middlePart.length());
            return String.format("%s\n%s\n%s", border, middlePart, border);
        }

        //Ex:
        /// ===============
        // === message ===
        // ===============
        public static String createTitle(String message, boolean newLineBefore, boolean newLineAfter) {
            String title = createTitle(message);

            if (newLineBefore)
                title = String.format("\n%s", title);

            if (newLineAfter)
                title = String.format("%s\n", title);

            return title;
        }

        //Ex:
        // ===============
        // === message ===
        // ===============
        public static String createTitle(String message, Character borderCharacter, boolean newLineBefore, boolean newLineAfter) {
            String title = createTitle(message, borderCharacter);

            if (newLineBefore)
                title = String.format("\n%s", title);

            if (newLineAfter)
                title = String.format("%s\n", title);

            return title;
        }


        //Ex:
        // ===============
        // === message ===
        // ===============
        public static void printTitle(String message) {
            String title = createTitle(message);
            System.out.println(title);
        }

        //Ex:
        // ===============
        // === message ===
        // ===============
        public static void printTitle(String message, Character borderChar) {
            String title = createTitle(message, borderChar);
            System.out.println(title);
        }

        //Ex:
        // ===============
        // === message ===
        // ===============
        public static void printTitle(String message, boolean newLineBefore, boolean newLineAfter) {
            String title = createTitle(message, newLineBefore, newLineAfter);
            System.out.println(title);
        }

        //Ex:
        // ===============
        // === message ===
        // ===============
        public static void printTitle(String message, Character borderChar, boolean newLineBefore, boolean newLineAfter) {
            if (message.length() == 0)
                return;

            String title = createTitle(message, borderChar, newLineBefore, newLineAfter);
            System.out.println(title);
        }

        //Ex:
        //
        // Title
        // -----------
        public static void printSubTitle(String title, boolean forceUppercase) {
            if (title.length() == 0)
                return;

            System.out.println();
            if (forceUppercase) {
                System.out.println(title.toUpperCase());
            } else{
                System.out.println(title);
            }
            System.out.println("-----------");
        }

        //Ex:
        //
        // Title
        // -----------
        public static void printSubSubTitle(String title, boolean forceUppercase) {
            if (title.length() == 0)
                return;

            System.out.println();
            if (forceUppercase) {
                System.out.println(title.toUpperCase());
            } else{
                System.out.println(title);
            }
        }
    }



    // Console INPUT
    // ---------------------------------------------------------------------------------------------------------
    public static class ConsoleIn {

        public static String readLineFromConsole(String prompt) {
            try {
                System.out.print(prompt);

                InputStreamReader converter = new InputStreamReader(System.in);
                BufferedReader in = new BufferedReader(converter);

                return in.readLine();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        public static int readIntegerFromConsole(String prompt) {
            do {
                try {
                    String input = readLineFromConsole(prompt);

                    int value = Integer.parseInt(input);

                    return value;
                } catch (NumberFormatException ex) {
                    Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
                }
            } while (true);
        }

        public static double readDoubleFromConsole(String prompt) {
            do {
                try {
                    String input = readLineFromConsole(prompt);

                    double value = Double.parseDouble(input);

                    return value;
                } catch (NumberFormatException ex) {
                    Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
                }
            } while (true);
        }

        public static Date readDateFromConsole(String prompt) {
            do {
                try {
                    String strDate;

                    do {
                        strDate = readLineFromConsole(String.format("%s (dd-mm-yyyy): ", prompt));
                        if (strDate.matches("\\d{2}-\\d{2}-\\d{4}")) {
                            break;
                        } else {
                            System.out.println("Invalid date format. Please enter the date in dd-mm-yyyy format.");
                        }
                    } while (true);

                    SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");

                    return df.parse(strDate);
                } catch (ParseException ex) {
                    Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
                }
            } while (true);
        }

        public static boolean readConfirmation(String message, String truePrompt, String falsePrompt) {
            String input;
            do {
                input = Utils.readLineFromConsole(String.format("\n%s ('%s' or '%s')\n", message, truePrompt, falsePrompt));
            } while (!input.equalsIgnoreCase(truePrompt) && !input.equalsIgnoreCase(falsePrompt));

            return input.equalsIgnoreCase(truePrompt);
        }

        public static <T> T selectOptionFromList(T[] list) {
            do {
                int index = Utils.readIntegerFromConsole("Select Option:");

                if (TiUtils.Lists.isIndexWithinBounds(list, index)) {
                    T selectedObject = list[index];
                    if (selectedObject != null) {
                        return selectedObject;
                    } else {
                        System.out.println("Selected option is null. Please select a valid option.");
                    }
                } else {
                    System.out.println("Invalid index. Please select a valid option.");
                }

            } while (true);
        }

        public static <T> T selectOptionFromList(List<T> list) {
            do {
                int index = Utils.readIntegerFromConsole("Select Option:");

                if (TiUtils.Lists.isIndexWithinBounds(list, index)) {
                    T selectedObject = list.get(index);
                    if (selectedObject != null) {
                        return selectedObject;
                    } else {
                        System.out.println("Selected option is null. Please select a valid option.");
                    }
                } else {
                    System.out.println("Invalid index. Please select a valid option.");
                }

            } while (true);
        }
    }
}
