package componentsForMain;

import classOrganiser.ConditionalOperators;

public class SwitchMethod extends CasesForSwitch {

    public void runSwitch(Integer caseNumber) {
        switch (caseNumber) {
            case 1:
                caseOne();
                break;
            case 2:
                caseTwo();
                break;
            case 3:
                caseThree();
                break;
            case 4:
                caseFour();
                break;
            default:
                System.out.println("INCORRECT VALUE");
                break;
        }
    }
}
