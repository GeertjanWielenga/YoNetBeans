package org.netbeans.modules.yo.template2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import org.openide.awt.StatusDisplayer;
import org.openide.explorer.ExplorerManager;
import org.openide.explorer.view.OutlineView;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.Children;
import org.openide.nodes.Node;

public class AllGeneratorsPanel extends JPanel implements ExplorerManager.Provider {

    private final ExplorerManager em;
    private final AllGeneratorsChildFactory ycf;

    public AllGeneratorsPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(new TitledBorder(new LineBorder(Color.BLACK, 1), "All Generators"));
        em = new ExplorerManager();
        OutlineView ov = new OutlineView("Status");
        ov.setPreferredSize(new Dimension(this.getWidth(), 100));
        ov.getOutline().setRootVisible(false);
        ov.setPropertyColumns("name", "Name", "stars", "Stars", "description", "Description");
        ycf = new AllGeneratorsChildFactory();
        Children kids = Children.create(ycf, true);
        AbstractNode rootNode = new AbstractNode(kids);
        add(ov);
        em.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                Node[] selectedNodes = em.getSelectedNodes();
                for (Node node : selectedNodes) {
                    StatusDisplayer.getDefault().setStatusText(node.getLookup().lookup(YeomanGeneratorObject.class).getDescription());
                }
            }
        });
        add(createInstalledGeneratorsCheckbox());
        em.setRootContext(rootNode);
    }

    private JCheckBox createInstalledGeneratorsCheckbox() {
        final JCheckBox cb = new JCheckBox("Show installed generators only");
        cb.setSelected(false);
        cb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cb.isSelected()) {
                    ycf.defineFilter(true, "Making only installed generators visible...");
                } else {
                    ycf.defineFilter(false, "Making all generators visible...");
                }
            }
        });
        return cb;
    }

    @Override
    public ExplorerManager getExplorerManager() {
        return em;
    }

}
