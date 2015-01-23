# YoNetBeans
<h3>NetBeans Tools for Yeoman</h3>

Background on what and why Yeoman: http://yeoman.io/

A key problem when creating IDE tools for Yeoman is that there is no "non-interactive" or batch mode available. Yeoman generators expect user interaction while Yeoman does not provide any mechanism for interacting programmatically. There's also the problem that each generator can decide for itself the options and arguments it makes available, so these are hard (impossible?) to predict or obtain. 

However, despite that, to some extent, tools can work around these problems, e.g., at least the generator name can be provided via a GUI and once the Output opens, the user can press Enter, accepting the defaults.

<h3>Rough List of Prioritized Issues</h3>

Strikethrough means the issue has been fixed.

<b>P1</b>
<ul>
<li><strike>Create new Yeoman configurations, register in menu, toolbar, shortcuts.</strike></li>
<li>Register Yo executable in Options window.</li>
<li><strike>Let location be specified when action is invoked, not when configuration is created.</strike></li>
</ul>
<b>P2</b>
<ul>
<li>Add Options window tab for customizing Yeoman configurations.</li>
<li>Add mechanism for deleting Yeoman configurations.</li>
</ul>
<b>P3</b>
<ul>
<li>Validation of GUI components in the wizard.</li>
<li><strike>Browse button in first step of the wizard, with FileChooserBuilder.</strike></li>
</ul>
<b>P4</b>
<ul>
<li>If parameter does not work/exist, automatically run 'npm install -g generator-' + parameter.</li>
<li>Screenscrape http://yeoman.io/generators/ and offer it in the parameter field, which should then be a list.</li>
<li><strike>Run 'yo --help' on the command line, like done with 'grails' and 'griffon' in NetBeans and then obtain the available generators and offer them in the parameter field, which should then be a list.</strike></li>
</ul>

<h3>Workflow</h3>

1. Open the New Project wizard.

   ![Alt text](/screenshots/yo-in-nb-1.png?raw=true "Step 1")

2. Click Next.

   ![Alt text](/screenshots/yo-in-nb-2.png?raw=true "Step 2")

3. Click Next.

   ![Alt text](/screenshots/yo-in-nb-3.png?raw=true "Step 3")

3. Click Finish. Together with the keyboard shortcut, a new menu item for invoking the Yo configuration has been created:

   ![Alt text](/screenshots/menu-yo.png?raw=true "Yo menu")

   Also, there's a new toolbar button that does the same thing:
   
   ![Alt text](/screenshots/toolbar-yo-1.png?raw=true "Yo toolbar")
   
   The configuration is stored in the user directory and persists across restarts. Multiple configurations can be created, i.e., for multiple different Yeoman generators and for multiple variations of the same Yeoman generator.
   
4. When the configuration is invoked via one of the GUI items, e.g., keyboard shortcut, menu item, or toolbar button, the following dialog is shown, where a (empty) folder should be specified, where the Yo generator will run:

   ![Alt text](/screenshots/yo-project-folder.png?raw=true "Yo toolbar")

   Next, when OK is clicked, the Output window opens. 

   ![Alt text](/screenshots/you-output-1.png?raw=true "Output window 1")

   The user can press Enter, accepting all the defaults. 

   ![Alt text](/screenshots/you-output-2.png?raw=true "Output window 2")

5. When the process is complete, opening the generated application in NetBeans is as simple as pointing to the root folder via this template:

   ![Alt text](/screenshots/yo-open.png?raw=true "Existing project")

   Then run, use the embedded browser, CSS tools, editors, etc.

   ![Alt text](/screenshots/yo-deploy-1.png?raw=true "Deployed project")
