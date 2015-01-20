# YoNetBeans
<h3>NetBeans Tools for Yeoman</h3>

<ul>
<li>TODO: Register Yo executable in Options window.
<li>DONE: Create new Yeoman configurations, register in menu, toolbar, shortcuts.</li>
<li>TODO: If parameter does not work/exist, automatically run 'npm install -g generator-' + parameter.</li>
<li>TODO: Add Options window tab for customizing Yeoman configurations.</li>
<li>TODO: Add mechanism for deleting Yeoman configurations.</li>
</ul>

<h3>Workflow</h3>

1. Click the "Add Yeoman Configuration..." menu item in the Tools menu.

   ![Alt text](/screenshots/add-yo-config-menu.png?raw=true "Add Yo configuration")

2. The "New Yeoman Configuration" wizard opens.

   ![Alt text](/screenshots/yoko.png?raw=true "Step 1 of wizard")

3. Click Next.

   ![Alt text](/screenshots/yoko2.png?raw=true "Step 2 of wizard")

3. Click Finish. A new menu item for invoking the Yo configuration has been created:

   ![Alt text](/screenshots/menu-yo.png?raw=true "Yo menu")

   Also, there's a new toolbar button that does the same thing:
   
   ![Alt text](/screenshots/toolbar-yo-1.png?raw=true "Yo menu")
   
The configuration is stored in the user directory and persists across restarts.
