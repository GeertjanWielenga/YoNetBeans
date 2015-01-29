package org.netbeans.modules.yo.template2;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import org.openide.explorer.ExplorerManager;
import org.openide.explorer.view.BeanTreeView;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.Children;
import org.openide.nodes.Node;

public class InstalledCommandPanel extends JPanel implements ExplorerManager.Provider {

    private final ExplorerManager em = new ExplorerManager();

    public InstalledCommandPanel() {
        setLayout(new BorderLayout());
        BeanTreeView installedCommandsView = new BeanTreeView();
        installedCommandsView.setRootVisible(false);
        Children kids = Children.create(new YeomanChildFactory(true, 1), true);
        Node rootNode = new AbstractNode(kids);
        add(installedCommandsView, BorderLayout.CENTER);
        em.setRootContext(rootNode);
    }
    
    @Override
    public ExplorerManager getExplorerManager() {
        return em;
    }
    
}
