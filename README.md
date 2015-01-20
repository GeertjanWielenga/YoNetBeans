# YoNetBeans
<h3>NetBeans Tools for Yeoman</h3>

A key problem when creating IDE tools for Yeoman is that there is no "non-interactive" or batch mode available. Yeoman generators expect user interaction while Yeoman does not provide any mechanism for interacting programmatically. However, despite that, to some extent, tools can work around this, e.g., at least the generator name can be provided via a GUI and once the Output opens, the user can press Enter, accepting the defaults, which is better than nothing.

<ul>
<li>TODO: Register Yo executable in Options window.
<li>DONE: Create new Yeoman configurations, register in menu, toolbar, shortcuts.</li>
<li>TODO: If parameter does not work/exist, automatically run 'npm install -g generator-' + parameter.</li>
<li>TODO: "Additional" checkbox in first step of the wizard, figure out how much can be done with it.</li>
<li>TODO: Add Options window tab for customizing Yeoman configurations.</li>
<li>TODO: Add mechanism for deleting Yeoman configurations.</li>
<li>TODO: Validation of GUI components in the wizard.</li>
<li>TODO: Browse button in first step of the wizard, with FileChooserBuilder.</li>
</ul>

<h3>Workflow</h3>

1. Click the "Add Yeoman Configuration..." menu item in the Tools menu.

   ![Alt text](/screenshots/add-yo-config-menu.png?raw=true "Add Yo configuration")

2. The "New Yeoman Configuration" wizard opens.

   ![Alt text](/screenshots/yoko.png?raw=true "Step 1 of wizard")

   - Parameter: "ko" or "webapp" or any of the other arguments that immediately follows "yo"
   - Additional: Whether a popup should appear for the value following the parameter, e.g., the name of the artifact.
   - Location: Folder on disk where "yo" should be run.

3. Click Next.

   ![Alt text](/screenshots/yoko2.png?raw=true "Step 2 of wizard")

3. Click Finish. Together with the keyboard shortcut, a new menu item for invoking the Yo configuration has been created:

   ![Alt text](/screenshots/menu-yo.png?raw=true "Yo menu")

   Also, there's a new toolbar button that does the same thing:
   
   ![Alt text](/screenshots/toolbar-yo-1.png?raw=true "Yo toolbar")
   
   The configuration is stored in the user directory and persists across restarts.
   
4. When the configuration is invoked via one of the GUI items, e.g., keyboard shortcut, menu item, or toolbar button, the Output window opens. 

   ![Alt text](/screenshots/you-output-1.png?raw=true "Output window 1")

The user can press Enter, accepting all the defaults. 

   ![Alt text](/screenshots/you-output-2.png?raw=true "Output window 2")
