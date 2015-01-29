package org.netbeans.modules.yo.template2;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import org.openide.explorer.ExplorerManager;
import org.openide.explorer.view.OutlineView;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.Children;
import org.openide.nodes.Node;

public class AllGeneratorsPanel extends JPanel implements ExplorerManager.Provider {
    
    private ExplorerManager em = new ExplorerManager();
    
    public AllGeneratorsPanel() {
        setLayout(new BorderLayout());
        OutlineView ov = new OutlineView();
        ov.getOutline().setRootVisible(false);
        ov.setPropertyColumns("installed", "In", "stars", "Stars", "description", "Description", "owner", "Owner", "website", "Website");
        Children kids = Children.create(new YeomanChildFactory(false, 2), true);
        Node rootNode = new AbstractNode(kids);
        add(ov, BorderLayout.CENTER);
        em.setRootContext(rootNode);
    }
    
    @Override
    public ExplorerManager getExplorerManager() {
        return em;
    }
    
}
