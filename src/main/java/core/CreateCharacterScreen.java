/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author Ronald
 */
public class CreateCharacterScreen extends JDialog {

    private JLabel strengthLabel;
    private JLabel finesseLabel;
    private JLabel enduranceLabel;
    private JLabel intelligenceLabel;
    private JLabel charismaLabel;

    private JButton strengthb;
    private JButton finesseb;
    private JButton enduranceb;
    private JButton intelligenceb;
    private JButton charismab;
    private JButton strengthbd;
    private JButton finessebd;
    private JButton endurancebd;
    private JButton intelligencebd;
    private JButton charismabd;

    private JLabel remainingPoints;
    private CreateMainCharacterModel createCharacterMethods;
    private JPanel abilities;
    private JButton Done;
    private final Object lock = new Object();

    /**
     *
     * @param model
     */
    public CreateCharacterScreen(CreateMainCharacterModel model) {
        createCharacterMethods = model;
        Component[] characterStartMenu = setButtons();
        abilities = new JPanel(new GridLayout(5, 3, 5, 5));
        this.setModalityType(ModalityType.APPLICATION_MODAL);
        for (Component characterStartMenu1 : characterStartMenu) {
            abilities.add(characterStartMenu1);
        }
        Done = new JButton("Done");
        Done.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                int result = JOptionPane.showConfirmDialog(
                        getThis(),
                        "Are you sure you spend all points the way you wanted?",
                        "..",
                        JOptionPane.YES_NO_OPTION);

                if (result == JOptionPane.YES_OPTION) {
                    MainMenu menu = new MainMenu();
                    menu.newGame(createCharacterMethods.returnCharacter());
                    MainGameScreen mdc = new MainGameScreen();
                    mdc.setVisible(true);
                    getThis().dispose();
                }
            }
        });
        
        add(abilities);
        add(remainingPoints);
        add(Done);

        this.setLayout(new FlowLayout());
        
        setSize(640, 480);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        
        
    }
        
    
    

    private class AbilityModificationButtonListener implements ActionListener {

        DefinedAbility ability;
        boolean incrementation;

        private AbilityModificationButtonListener(DefinedAbility ability, boolean incrementation) {
            this.ability = ability;
            this.incrementation = incrementation;
        }

        private void updateLabelValue() {
            switch (ability) {
                case STRENGTH:
                    strengthLabel.setText("Strength: " + createCharacterMethods.getStrength());
                    remainingPoints.setText("Remaining Points: " + createCharacterMethods.getPointCounter());
                    break;
                case FINESSE:
                    finesseLabel.setText("Finesse: " + createCharacterMethods.getFinesse());
                    remainingPoints.setText("Remaining Points: " + createCharacterMethods.getPointCounter());
                    break;
                case ENDURANCE:
                    enduranceLabel.setText("Endurance: " + createCharacterMethods.getEndurance());
                    remainingPoints.setText("Remaining Points: " + createCharacterMethods.getPointCounter());
                    break;
                case INTELLIGENCE:
                    intelligenceLabel.setText("Intelligence: " + createCharacterMethods.getIntelligence());
                    remainingPoints.setText("Remaining Points: " + createCharacterMethods.getPointCounter());
                    break;
                case CHARISMA:
                    charismaLabel.setText("Charisma: " + createCharacterMethods.getCharisma());
                    remainingPoints.setText("Remaining Points: " + createCharacterMethods.getPointCounter());
                    break;
            }
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (incrementation) {
                createCharacterMethods.incrementPoints(ability);
                updateLabelValue();
            } else {
                createCharacterMethods.decrementPoints(ability);
                updateLabelValue();
            }
        }
    }

    private Component[] setButtons() {
        strengthLabel = new JLabel("Strength: " + createCharacterMethods.getStartingCharacteristics());
        strengthLabel.setToolTipText(DefinedAbility.STRENGTH.getDescription());
        strengthb = new JButton("+");
        strengthbd = new JButton("-");
        finesseLabel = new JLabel("Finesse: " + createCharacterMethods.getStartingCharacteristics());
        finesseLabel.setToolTipText(DefinedAbility.FINESSE.getDescription());
        finesseb = new JButton("+");
        finessebd = new JButton("-");
        enduranceLabel = new JLabel("Endurance: " + createCharacterMethods.getStartingCharacteristics());
        enduranceLabel.setToolTipText(DefinedAbility.ENDURANCE.getDescription());
        enduranceb = new JButton("+");
        endurancebd = new JButton("-");
        intelligenceLabel = new JLabel("Intelligence: " + createCharacterMethods.getStartingCharacteristics());
        intelligenceLabel.setToolTipText(DefinedAbility.INTELLIGENCE.getDescription());
        intelligenceb = new JButton("+");
        intelligencebd = new JButton("-");
        charismaLabel = new JLabel("Charisma: " + createCharacterMethods.getStartingCharacteristics());
        charismaLabel.setToolTipText(DefinedAbility.CHARISMA.getDescription());
        charismab = new JButton("+");
        charismabd = new JButton("-");

        remainingPoints = new JLabel("Remaining Points: " + createCharacterMethods.getPointCounter());

        strengthb.addActionListener(new AbilityModificationButtonListener(DefinedAbility.STRENGTH, true));
        strengthbd.addActionListener(new AbilityModificationButtonListener(DefinedAbility.STRENGTH, false));
        finesseb.addActionListener(new AbilityModificationButtonListener(DefinedAbility.FINESSE, true));
        finessebd.addActionListener(new AbilityModificationButtonListener(DefinedAbility.FINESSE, false));
        enduranceb.addActionListener(new AbilityModificationButtonListener(DefinedAbility.ENDURANCE, true));
        endurancebd.addActionListener(new AbilityModificationButtonListener(DefinedAbility.ENDURANCE, false));
        intelligenceb.addActionListener(new AbilityModificationButtonListener(DefinedAbility.INTELLIGENCE, true));
        intelligencebd.addActionListener(new AbilityModificationButtonListener(DefinedAbility.INTELLIGENCE, false));
        charismab.addActionListener(new AbilityModificationButtonListener(DefinedAbility.CHARISMA, true));
        charismabd.addActionListener(new AbilityModificationButtonListener(DefinedAbility.CHARISMA, false));

        Component[] characterStartMenu = {strengthLabel, strengthb, strengthbd, finesseLabel, finesseb, finessebd, enduranceLabel, enduranceb, endurancebd, intelligenceLabel, intelligenceb, intelligencebd, charismaLabel, charismab, charismabd};
        return characterStartMenu;
    }

    private JDialog getThis() {
        return this;
    }

    
}
