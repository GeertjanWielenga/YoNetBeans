package org.netbeans.modules.yo.template2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import org.openide.explorer.ExplorerManager;
import org.openide.explorer.view.OutlineView;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.Children;

public class AllGeneratorsPanel extends JPanel implements ExplorerManager.Provider {

    private final ExplorerManager em;
    private final AllGeneratorsChildFactory ycf;

    public AllGeneratorsPanel() {
        setLayout(new BorderLayout());
        setBorder(new TitledBorder(new LineBorder(Color.BLACK, 1), "All Generators"));
        em = new ExplorerManager();
        OutlineView ov = new OutlineView("Status");
        ov.setPreferredSize(new Dimension(this.getWidth(), 100));
        ov.getOutline().setRootVisible(false);
        ov.setPropertyColumns("name", "Name", "stars", "Stars", "description", "Description");
        ycf = new AllGeneratorsChildFactory();
        Children kids = Children.create(ycf, true);
        AbstractNode rootNode = new AbstractNode(kids);
        add(ov, BorderLayout.CENTER);
        add(createInstalledGeneratorsCheckbox(), BorderLayout.SOUTH);
        em.setRootContext(rootNode);
    }

    private JCheckBox createInstalledGeneratorsCheckbox() {
        final JCheckBox cb = new JCheckBox("Show installed generators only");
        cb.setSelected(false);
        cb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cb.isSelected()) {
                    ycf.defineFilter(true,"Making only installed generators visible...");
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
