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
<li>Validation of GUI components in the wizard.</li>
<li><strike>Browse button in first step of the wizard, with FileChooserBuilder.</strike></li>
</ul>
<b>P3</b>
<ul>
<li>If parameter does not work/exist, automatically run 'npm install -g generator-' + parameter.</li>
<li>Screenscrape http://yeoman.io/generators/ and offer it in the parameter field, which should then be a list.</li>
<li><strike>Run 'yo --help' on the command line, like done with 'grails' and 'griffon' in NetBeans and then obtain the available generators and offer them in the parameter field, which should then be a list.</strike></li>
</ul>

<h3>Workflow</h3>

1. Set the yo.cmd in the Options window.

   ![Alt text](/screenshots/options.png?raw=true "Step 1")


2. Open the New Project wizard. Choose HTML5 | HTML5 Application from Yeoman.

   ![Alt text](/screenshots/yo-in-nb-1.png?raw=true "Step 1")

3. Click Next.

   ![Alt text](/screenshots/yo-in-nb-2.png?raw=true "Step 2")

   Choose one of the installed Yeoman commands. Generators can also be installed. 

4. Click Next.

   ![Alt text](/screenshots/yo-in-nb-3.png?raw=true "Step 3")

5. Click Finish. The application is generated via Yeoman and opens in the IDE.

   ![Alt text](/screenshots/yo-in-nb-4.png?raw=true "Yo menu")

   The selected Yeoman generator is used to generate the application.
