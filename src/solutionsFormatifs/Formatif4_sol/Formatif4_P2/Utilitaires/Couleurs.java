package solutionsFormatifs.Formatif4_sol.Formatif4_P2.Utilitaires;

/**
 * Classe utilitaire contenant l'ensemble des codes d'échappement ANSI
 * permettant d'ajouter de la couleur et un style au texte affiché
 * dans la console.
 *
 * Les chaînes définies ici peuvent être utilisées pour colorer un texte,
 * changer la couleur du fond ou appliquer un style (gras, souligné, etc.).
 *
 * Notes :
 * - Les codes ANSI sont supportés nativement sous Linux, macOS et
 *   sous Windows 10+ (cmd, PowerShell, Windows Terminal).
 * - Toujours utiliser RESET après un texte stylé pour revenir
 *   à l'affichage normal.
 */
public final class Couleurs {

    // Réinitialisation
    public static final String RESET = "\u001B[0m";

    // Styles
    public static final String GRAS = "\u001B[1m";
    public static final String SOULIGNE = "\u001B[4m";
    public static final String CLIGNOTANT = "\u001B[5m";

    // Couleurs du texte
    public static final String NOIR = "\u001B[30m";
    public static final String ROUGE = "\u001B[31m";
    public static final String VERT = "\u001B[32m";
    public static final String JAUNE = "\u001B[33m";
    public static final String BLEU = "\u001B[34m";
    public static final String MAGENTA = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String BLANC = "\u001B[37m";

    // Couleurs du texte (versions vives)
    public static final String NOIR_VIF = "\u001B[90m";
    public static final String ROUGE_VIF = "\u001B[91m";
    public static final String VERT_VIF = "\u001B[92m";
    public static final String JAUNE_VIF = "\u001B[93m";
    public static final String BLEU_VIF = "\u001B[94m";
    public static final String MAGENTA_VIF = "\u001B[95m";
    public static final String CYAN_VIF = "\u001B[96m";
    public static final String BLANC_VIF = "\u001B[97m";

    // Couleurs de fond
    public static final String FOND_NOIR = "\u001B[40m";
    public static final String FOND_ROUGE = "\u001B[41m";
    public static final String FOND_VERT = "\u001B[42m";
    public static final String FOND_JAUNE = "\u001B[43m";
    public static final String FOND_BLEU = "\u001B[44m";
    public static final String FOND_MAGENTA = "\u001B[45m";
    public static final String FOND_CYAN = "\u001B[46m";
    public static final String FOND_BLANC = "\u001B[47m";

    // Couleurs de fond vives
    public static final String FOND_NOIR_VIF = "\u001B[100m";
    public static final String FOND_ROUGE_VIF = "\u001B[101m";
    public static final String FOND_VERT_VIF = "\u001B[102m";
    public static final String FOND_JAUNE_VIF = "\u001B[103m";
    public static final String FOND_BLEU_VIF = "\u001B[104m";
    public static final String FOND_MAGENTA_VIF = "\u001B[105m";
    public static final String FOND_CYAN_VIF = "\u001B[106m";
    public static final String FOND_BLANC_VIF = "\u001B[107m";

    public static void main(String[] args) {
        // Exemple
        System.out.println(ROUGE + "Texte en rouge" + RESET + " et " + BLEU + "texte en bleu" + RESET);
    }
}
