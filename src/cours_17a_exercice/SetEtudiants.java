package cours_17a_exercice;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetEtudiants {
    private Set<Etudiant> setEtudiants;

    public SetEtudiants(Collection<Etudiant> etudiants) {
        //todo
      //  setEtudiants = new HashSet<>(etudiants);
        setEtudiants = new TreeSet<>(etudiants);

    }

    public void add(Etudiant etudiant) {
        //todo
        setEtudiants.add(etudiant);
    }


    public boolean replace(Etudiant oldEtudiant, Etudiant newEtudiant) {
        //todo
        if (setEtudiants.remove(oldEtudiant)) {
            return setEtudiants.add(newEtudiant);
        }
        return false;
    }

    /**
     *
     * @param noEtudiant
     * @return null si l'étudiant n'est pas trouvé
     */
    public Etudiant get(int noEtudiant) {
        //todo
        for (Etudiant etudiant: setEtudiants) {
            if(etudiant.getNoDA() == noEtudiant) {
                return etudiant;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "SetEtudiants{" +
                "setEtudiants=" + setEtudiants +
                '}';
    }
}
