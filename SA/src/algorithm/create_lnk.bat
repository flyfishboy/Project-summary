echo ThePath = "D:\My_Study\SA\学习监督管理系统.exe">aaa.vbs
echo lnkname = "学习监督管理系统.lnk">>aaa.vbs
echo WS = "Wscript.Shell">>aaa.vbs
echo Set Shell = CreateObject(WS)>>aaa.vbs
echo Set Link = Shell.CreateShortcut(lnkname)>>aaa.vbs
echo Link.TargetPath = ThePath>>aaa.vbs
echo Link.Save>>aaa.vbs
echo Set fso = CreateObject("Scripting.FileSystemObject")>>aaa.vbs
echo f = fso.DeleteFile(WScript.ScriptName)>>aaa.vbs
cmd.exe /c start aaa.vbs