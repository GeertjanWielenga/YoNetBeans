package org.netbeans.modules.yo.template2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import org.openide.explorer.ExplorerManager;
import org.openide.explorer.view.BeanTreeView;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.Children;
import org.openide.nodes.Node;

public class InstalledCommandPanel extends JPanel implements ExplorerManager.Provider {

    private final ExplorerManager em = new ExplorerManager();

    public InstalledCommandPanel() {
        setLayout(new BorderLayout());
        setBorder(new TitledBorder(new LineBorder(Color.BLACK, 1), "Installed Commands"));
        BeanTreeView installedCommandsView = new BeanTreeView();
        installedCommandsView.setPreferredSize(new Dimension(this.getWidth(),100));
        installedCommandsView.setRootVisible(false);
        Children kids = Children.create(new InstalledCommandChildFactory(), true);
        Node rootNode = new AbstractNode(kids);
        add(installedCommandsView, BorderLayout.CENTER);
        em.setRootContext(rootNode);
    }
    
    @Override
    public ExplorerManager getExplorerManager() {
        return em;
    }
    
}
