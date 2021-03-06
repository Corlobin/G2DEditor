package br.ol.g2d.editor.animation.scripting;

import br.ol.g2d.AnimationObjectInterface;
import br.ol.g2d.AnimationSpriteObject;
import br.ol.g2d.G2DContext;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * AnimationBakingScript class.
 * 
 * @author Leonardo Ono (ono.leo@gmail.com)
 */
public class AnimationBakingScript extends javax.swing.JPanel {
    
    private G2DContext context;

    /**
     * Creates new form AnimationBakingScript
     */
    public AnimationBakingScript() {
        initComponents();
    }

    public G2DContext getContext() {
        return context;
    }

    public void setContext(G2DContext context) {
        this.context = context;
    }

    public void init() {
        textStartFrame.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
            }

            @Override
            public void focusLost(FocusEvent e) {
                try {
                    getAnimationSpriteObject().scriptStartFrame = Integer.parseInt(textStartFrame.getText());
                }
                catch (Exception ex) {
                }
                repaint();
            }
        });
        textEndFrame.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
            }

            @Override
            public void focusLost(FocusEvent e) {
                try {
                    getAnimationSpriteObject().scriptEndFrame = Integer.parseInt(textEndFrame.getText());
                }
                catch (Exception ex) {
                }
                repaint();
            }
        });
        textScript.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
            }

            @Override
            public void focusLost(FocusEvent e) {
                try {
                    getAnimationSpriteObject().setPreviewScript(textScript.getText());
                }
                catch (Exception ex) {
                }
                repaint();
            }
        });
    }

    public void update() {
        setEnabled(context != null && getAnimationSpriteObject() != null);
        textStartFrame.setEnabled(isEnabled());
        textEndFrame.setEnabled(isEnabled());
        textScript.setEnabled(isEnabled());
        buttonBake.setEnabled(isEnabled());
        buttonPreview.setEnabled(isEnabled());
        buttonPreview.setSelected(getAnimationSpriteObject().useScriptPreview && buttonPreview.isEnabled());
        
        if (textStartFrame.isEnabled()) {
            textStartFrame.setText(getAnimationSpriteObject().scriptStartFrame + "");
        }
        else {
            textStartFrame.setText("");
        }

        if (textEndFrame.isEnabled()) {
            textEndFrame.setText(getAnimationSpriteObject().scriptEndFrame + "");
        }
        else {
            textEndFrame.setText("");
        }

        if (textScript.isEnabled() && textScript.getText().trim().isEmpty()) {
            textScript.setText(getAnimationSpriteObject().previewScript + "");
        }
        else if (!textScript.isEnabled()) {
            textScript.setText("");
        }
        
        repaint();
    }    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        textStartFrame = new javax.swing.JTextField();
        textEndFrame = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        buttonBake = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        textScript = new javax.swing.JTextArea();
        buttonPreview = new javax.swing.JToggleButton();

        jLabel1.setText("Start frame:");

        textStartFrame.setText("1");

        textEndFrame.setText("1");

        jLabel2.setText("End frame:");

        buttonBake.setText("Bake");
        buttonBake.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBakeActionPerformed(evt);
            }
        });

        textScript.setColumns(20);
        textScript.setRows(5);
        jScrollPane1.setViewportView(textScript);

        buttonPreview.setText("Preview");
        buttonPreview.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPreviewActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textStartFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textEndFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonPreview)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonBake)
                .addContainerGap(135, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(textStartFrame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(textEndFrame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonBake)
                    .addComponent(buttonPreview))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonPreviewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPreviewActionPerformed
        getAnimationSpriteObject().useScriptPreview = buttonPreview.isSelected();
    }//GEN-LAST:event_buttonPreviewActionPerformed

    private void buttonBakeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBakeActionPerformed
        bakeScriptAnimation();
    }//GEN-LAST:event_buttonBakeActionPerformed

    private AnimationSpriteObject getAnimationSpriteObject() {
        AnimationObjectInterface selectedAnimationObject = context.getSelectedAnimationObject();
        if (!(selectedAnimationObject instanceof AnimationSpriteObject)) {
            return null;
        }
        return (AnimationSpriteObject) selectedAnimationObject;        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonBake;
    private javax.swing.JToggleButton buttonPreview;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField textEndFrame;
    private javax.swing.JTextArea textScript;
    private javax.swing.JTextField textStartFrame;
    // End of variables declaration//GEN-END:variables

    private void bakeScriptAnimation() {
        AnimationSpriteObject animation = getAnimationSpriteObject();
        if (animation == null) {
            return;
        }
        try {
            animation.bakeScriptAnimation();
            animation.useScriptPreview = false;
            context.update();
            JOptionPane.showMessageDialog(JOptionPane.getFrameForComponent(this), "Script animation baked successfully.", "Info", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(JOptionPane.getFrameForComponent(this), "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
