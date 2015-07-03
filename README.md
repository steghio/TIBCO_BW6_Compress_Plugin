# TIBCO_BW6_Compress_Plugin
TIBCO BusinessWorks 6 Compress Plugin for Zip and Unzip activities

This plugin adds a Compress palette to BW6 with Zip and Unzip activities. It was created and tested on BW6.2.1 HF3

Reference documentation is available at: http://digilander.libero.it/otacoconvention/archivi/TIBCO_BW6_Compress_plugin/index.html

To access the documentation from BusinessStudio you must be connected to the internet, right click on the activity and choose Help->Reference page. You can also download the zipped documentation from the Docs folder

Please refer to the PDK development doc for how setup Eclipse and the child Eclipse, import the projects and edit the plugin: https://docs.tibco.com/pub/bwpdk/6.0.0/doc/pdf/TIB_bwpdk_6.0_developer's_guide.pdf

The sources are under Sources/Compress

The sample projects SampleZip and SampleUnzip under Sources can instead be imported as "Studio project from Archive". They require you to install the Compress plugin in your Eclipse to work

If you intend to view/edit the source, after importing the Design/Module projects in your workspace, make sure to change the Target Platform to "Running Platform": Window->Preferences->Plug-in Development->Target Platform

For the Runtime projects instead the default bw-runtime is correct