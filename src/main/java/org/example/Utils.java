package org.example;

import java.util.*;

public final class Utils {
    private static Random random = new Random();
    private static Scanner input = new Scanner(System.in);

    // arrays/vetores estáticos:
    static final String[] ALPHABETO = {
            "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M",
            "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"
    };
    static final String[] NOMES         = { "Vânia", "Humberto", "Tiago", "Rafa", "Anna", "Isa", "Clarissa", "Pedro", "Nuno", "Pedro", "Fransisco", "Solange", "Fábio", "Hugo", "Susana", "Tânia", "Wilson", "Sónia", "João" };
    static final String[] APELIDOS      = { "Delgado", "Barracha", "Silva", "Pereira", "Figueiredo", "Mota", "Costa", "Peixoto", "Brasão", "Vasconcelos", "Sarzedo", "Cabral" };
    static final String[] MORADAS       = { "Amarante", "Lisboa", "Porto", "Alcobaça", "Ovar", "Viseu", "Leiria", "Caldas da Rainha" };
    static final String[] EMPRESAS      = { "UpSkill", "Minsait", "Indra", "Critial", "Outsystems", "Microsoft", "Amazon", "Apple", "Google", "Facebook", "LinkedIn", "Twitter" };
    static final String[] PROFISSOES    = { "Programador", "Front-End Dev", "Back-End Dev", "Empresário", "Artista", "Professor", "Carpinteiro", "Cerralheiro", "Mecânico" };
    static final String[] CORES         = { "Vermelho", "Azul", "Verde", "Amarelo", "Laranja", "Roxo", "Rosa", "Cinza", "Preto", "Branco" };
    static final String[] NACIONALIDADES = { "Portuguesa", "Espanhola", "Francesa", "Italiana", "Alemã", "Inglesa", "Brasileira" };

    static final Boolean[] TRUE_OR_FALSE = { true, false };

    /**
     * Retorna um elemento aleatório dentro dos limites do array de input
     * @param array de referência
     * @return elemento do array aleatório
     * @param <T>
     */
    public static  <T>T getRandomFromArray(T[] array) {
        int index = random.nextInt(0, array.length);
        return array[index];
    }


    /**
     * Retorna um elemento aleatório dentro dos limites do arrayList de input
     * @param arrayList de referência
     * @return elemento do arrayList aleatório
     * @param <T>
     */
    public static  <T>T getRandomFromArrayList(ArrayList<T> arrayList) {
        int index = random.nextInt(0, arrayList.size());
        return arrayList.get(index);
    }

    public static <T> List<T> getTipoDeObjeto(Class<T> type, T[] array) {
        List<T> result = new ArrayList<>();

        for (Object obj : array) {
            if (obj != null || type.isInstance(obj) == true) {
                result.add(type.cast(obj));
            }
        }

        return result;
    }

    public static <T> List<T> getTipoDeObjeto(Class<T> type, List<T> list) {
        List<T> result = new ArrayList<>();

        for (Object obj : list) {
            if (obj != null || type.isInstance(obj) == true) {
                result.add(type.cast(obj));
            }
        }

        return result;
    }

    public static <T extends Enum<?>> T getRandomEnumValue(Class<T> enumClass) {
        T[] enumValues = enumClass.getEnumConstants();
        return enumValues[random.nextInt(enumValues.length)];
    }

    public static boolean nextTrueOrFalse() {
        return getRandomFromArray(TRUE_OR_FALSE);
    }

    public static String getRandomAlphabetLetter() { return getRandomFromArray(ALPHABETO); }

    public static String getRandomNome() { return getRandomFromArray(NOMES); }

    public static String getRandomApelido() {
        return getRandomFromArray(APELIDOS);
    }

    public static String getRandomNomeCompleto() {
        return String.format("%s %s", getRandomNome(), getRandomApelido());
    }

    public static String getRandomMorada() {
        return getRandomFromArray(MORADAS);
    }

    public static String getRandomEmpresa() {
        return getRandomFromArray(EMPRESAS);
    }

    public static String getRandomProfissao() {
        return getRandomFromArray(PROFISSOES);
    }

    public static String getRandomCor() {
        return getRandomFromArray(CORES);
    }

    public static String getRandomNacionalidade() { return getRandomFromArray(NACIONALIDADES); }

    public static int getRandomIdade(int min, int max) {
        return random.nextInt(min, max + 1);
    }

    public static String getRandomNumberID(int idLength) {
        String id = "";

        if (idLength <= 0)
            idLength = 12;

        for (int i = 0; i < idLength; i++) {
            id = String.format("%s%d", id, random.nextInt(10));
        }

        return id;
    }


    /**
     * Cria e retorna um título (string) para ser usado no console log
     * @param message mensagem no meio
     * @return retorna o título com a mensagem
     */
    //Ex:
    // ================
    // === Mensagem ===
    // ================
    public static String createTitle(String message) {
        String middlePart = "=== " + message + " ===";
        String border = "=".repeat(middlePart.length());
        return String.format("%s\n%s\n%s", border, middlePart, border);
    }

    /**
     * Cria e retorna um título (string) para ser usado no console log
     * @param message mensagem no meio
     * @return retorna o título com a mensagem
     */
    //Ex:
    // ================
    // === Mensagem ===
    // ================
    public static String createTitle(String message, char borderChar) {
        String middleBorder = String.valueOf(borderChar).repeat(3);
        String middlePart = middleBorder + " " + message + " " + middleBorder;
        String border = String.valueOf(borderChar).repeat(middlePart.length());
        return String.format("%s\n%s\n%s", border, middlePart, border);
    }

    /**
     * Cria e retorna uma string como a do exemplo, com a mensagem no meio
     * @param message mensagem no meio
     * @param newLineBefore se é preciso fazer um New Line *ANTES* do título
     * @param newLineAfter se é preciso fazer um New Line *DEPOIS* do título
     * @return retorna o título com a mensagem
     */
    //Ex:
    // ================
    // === Mensagem ===
    // ================
    public static String createTitle(String message, boolean newLineBefore, boolean newLineAfter) {
        String title = createTitle(message);

        if (newLineBefore)
            title = String.format("\n%s", title);

        if (newLineAfter)
            title = String.format("%s\n", title);

        return title;
    }

    /**
     * Cria e retorna uma string como a do exemplo, com a mensagem no meio
     * @param message mensagem no meio
     * @param newLineBefore se é preciso fazer um New Line *ANTES* do título
     * @param newLineAfter se é preciso fazer um New Line *DEPOIS* do título
     * @return retorna o título com a mensagem
     */
    //Ex:
    // ================
    // === Mensagem ===
    // ================
    public static String createTitle(String message, Character borderCharacter, boolean newLineBefore, boolean newLineAfter) {
        String title = createTitle(message, borderCharacter);

        if (newLineBefore)
            title = String.format("\n%s", title);

        if (newLineAfter)
            title = String.format("%s\n", title);

        return title;
    }


    /**
     * Cria um título e faz print do mesmo
     * @param message a mensagem no meio do título
     */
    //Ex:
    // ================
    // === Mensagem ===
    // ================
    public static void printTitle(String message) {
        String title = createTitle(message);
        System.out.println(title);
    }

    /**
     * Cria um título e faz print do mesmo
     * @param message a mensagem no meio do título
     */
    //Ex:
    // ================
    // === Mensagem ===
    // ================
    public static void printTitle(String message, Character borderChar) {
        String title = createTitle(message, borderChar);
        System.out.println(title);
    }

    /**
     * Cria e faz print line da mensagem em formato de título
     * @param message mensagem no meio
     * @param newLineBefore se é preciso fazer um New Line *ANTES* do título
     * @param newLineAfter se é preciso fazer um New Line *DEPOIS* do título
     * @return retorna o título com a mensagem
     */
    //Ex:
    // ================
    // === Mensagem ===
    // ================
    public static void printTitle(String message, boolean newLineBefore, boolean newLineAfter) {
        String title = createTitle(message, newLineBefore, newLineAfter);
        System.out.println(title);
    }

    /**
     * Cria e faz print line da mensagem em formato de título
     * @param message mensagem no meio
     * @param newLineBefore se é preciso fazer um New Line *ANTES* do título
     * @param newLineAfter se é preciso fazer um New Line *DEPOIS* do título
     * @return retorna o título com a mensagem
     */
    //Ex:
    // ================
    // === Mensagem ===
    // ================
    public static void printTitle(String message, Character borderChar, boolean newLineBefore, boolean newLineAfter) {
        String title = createTitle(message, borderChar, newLineBefore, newLineAfter);
        System.out.println(title);
    }

    public static float getInputFloat() {
        float inFloat = 0;

        while (true) {
            try {
                inFloat = input.nextFloat();
                input.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Valor real inválido...");
                input.nextLine();
            }
        }

        return inFloat;
    }

    public static float getInputFloat(float min, float max) {
        float inFloat = 0;

        while (true) {
            try {
                do {
                    inFloat = input.nextInt();

                    if (inFloat < min)
                        System.out.println("Valor é MENOR do valor mínimo...");
                    if (inFloat > max)
                        System.out.println("Valor é MAIOR que o valor máximo...");
                } while (inFloat < min || inFloat > max);

                input.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Valor real inválido...");
                input.nextLine();
            }
        }

        return inFloat;
    }

    public static double getInputDouble() {
        double inDouble = 0;

        while (true) {
            try {
                inDouble = input.nextDouble();
                input.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Valor real inválido...");
                input.nextLine();
            }
        }

        return inDouble;
    }

    public static double getInputDouble(double min, double max) {
        double inDouble = 0;

        while (true) {
            try {
                do {
                    inDouble = input.nextInt();

                    if (inDouble < min)
                        System.out.println("Valor é MENOR do valor mínimo...");
                    if (inDouble > max)
                        System.out.println("Valor é MAIOR que o valor máximo...");
                } while (inDouble < min || inDouble > max);

                input.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Valor real inválido...");
                input.nextLine();
            }
        }

        return inDouble;
    }

    public static int getInputInt() {
        int inInt = 0;

        while (true) {
            try {
                inInt = input.nextInt();
                input.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Valor inteiro inválido...");
                input.nextLine();
            }
        }

        return inInt;
    }

    public static int getInputInt(int min, int max) {
        int inInt = 0;

        while (true) {
            try {
                do {
                    inInt = input.nextInt();

                    if (inInt < min)
                        System.out.println("Valor é MENOR do valor mínimo...");
                    if (inInt > max)
                        System.out.println("Valor é MAIOR que o valor máximo...");
                } while (inInt < min || inInt > max);

                input.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Valor inteiro inválido...");
                input.nextLine();
            }
        }

        return inInt;
    }

    public static String getStringInput(int minCharacterCount) {
        String str = "";

        while (true) {
            try {
                do {
                    System.out.print("Enter a string with at least " + minCharacterCount + " characters: ");
                    str = input.nextLine();
                } while (str.length() < minCharacterCount);

                return str;
            } catch (InputMismatchException e) {
                System.out.println(String.format("Input inválido. Inserir mínimo de %s characteres", minCharacterCount));
                input.nextLine();
            }
        }
    }

    public static boolean getBooleanInput(String inputForTrue, String inputForFalse) {
        while (true) {
            System.out.println(String.format("Inserir '%s' para VERDADEIRO ou '%s' para FALSO:", inputForTrue, inputForFalse));
            String choice = input.nextLine().trim();

            if (choice.equalsIgnoreCase(inputForTrue)) {
                return true;
            } else if (choice.equalsIgnoreCase(inputForFalse)) {
                return false;
            } else {
                System.out.println(String.format("Input inválido... Inserir '%s' para VERDADEIRO ou '%s' para FALSO:", inputForTrue, inputForFalse));
            }
        }
    }
}
