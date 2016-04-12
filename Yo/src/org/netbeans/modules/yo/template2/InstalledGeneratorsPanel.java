package org.netbeans.modules.yo.template2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import org.openide.explorer.ExplorerManager;
import org.openide.explorer.view.BeanTreeView;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.Children;
import org.openide.nodes.Node;

public class InstalledGeneratorsPanel extends JPanel implements ExplorerManager.Provider {

    private final ExplorerManager em = new ExplorerManager();
    private final InstalledGeneratorsChildFactory iccf;

    public InstalledGeneratorsPanel() {
        setLayout(new BorderLayout());
        setBorder(new LineBorder(Color.BLACK, 1));
        BeanTreeView installedCommandsView = new BeanTreeView();
        installedCommandsView.setPreferredSize(new Dimension(this.getWidth(),100));
        installedCommandsView.setRootVisible(false);
        iccf = new InstalledGeneratorsChildFactory();
        Children kids = Children.create(iccf, true);
        Node rootNode = new AbstractNode(kids);
        add(installedCommandsView, BorderLayout.CENTER);
        em.setRootContext(rootNode);
    }

    @Override
    public ExplorerManager getExplorerManager() {
        return em;
    }

    public String getSelectedGenerator() {
        return iccf.getSelectedGenerator();
    }

}
