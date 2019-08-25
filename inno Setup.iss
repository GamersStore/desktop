; Script generated by the Inno Setup Script Wizard.
; SEE THE DOCUMENTATION FOR DETAILS ON CREATING INNO SETUP SCRIPT FILES!

#define MyAppName "GamersStore"
#define MyAppVersion "1.0.0.0"
#define MyAppPublisher "Luis Acxis"
#define MyAppURL "https://GamersStore.xyz"
#define MyAppExeName "GamersStore.exe"

[Setup]
; NOTE: The value of AppId uniquely identifies this application. Do not use the same AppId value in installers for other applications.
; (To generate a new GUID, click Tools | Generate GUID inside the IDE.)
AppId={{1AFC4003-142F-4C42-80FA-208824810DC2}
AppName={#MyAppName}
AppVersion={#MyAppVersion}
;AppVerName={#MyAppName} {#MyAppVersion}
AppPublisher={#MyAppPublisher}
AppPublisherURL={#MyAppURL}
AppSupportURL={#MyAppURL}
AppUpdatesURL={#MyAppURL}
DefaultDirName={autopf}\{#MyAppName}
DisableDirPage=yes
DisableProgramGroupPage=yes
; The [Icons] "quicklaunchicon" entry uses {userappdata} but its [Tasks] entry has a proper IsAdminInstallMode Check.
UsedUserAreasWarning=no
; Uncomment the following line to run in non administrative install mode (install for current user only.)
;PrivilegesRequired=lowest
OutputDir=C:\Users\Luis Acxis\Desktop
OutputBaseFilename=install.GamersStore
SetupIconFile=C:\Users\Luis Acxis\Documents\NetBeansProjects\GamersStore\src\lib\images\ico-LogoGS-color-35x35.ico
Compression=lzma
SolidCompression=yes
WizardStyle=modern

[Languages]
Name: "spanish"; MessagesFile: "compiler:Languages\Spanish.isl"

[Tasks]
Name: "desktopicon"; Description: "{cm:CreateDesktopIcon}"; GroupDescription: "{cm:AdditionalIcons}"; Flags: unchecked
Name: "quicklaunchicon"; Description: "{cm:CreateQuickLaunchIcon}"; GroupDescription: "{cm:AdditionalIcons}"; Flags: unchecked; OnlyBelowVersion: 6.1; Check: not IsAdminInstallMode

[Files]
Source: "C:\Users\Luis Acxis\Desktop\GamersStore\GamersStore.exe"; DestDir: "{app}"; Flags: ignoreversion
Source: "C:\Users\Luis Acxis\Desktop\GamersStore\lib\*"; DestDir: "{app}"; Flags: ignoreversion recursesubdirs createallsubdirs
Source: "C:\Users\Luis Acxis\Desktop\GamersStore\addMenuGamersLink.bat"; DestDir: "{app}"; Flags: ignoreversion
Source: "C:\Users\Luis Acxis\Desktop\GamersStore\createlnk.vbs"; DestDir: "{app}"; Flags: ignoreversion
Source: "C:\Users\Luis Acxis\Desktop\GamersStore\GamersStore.s3db"; DestDir: "{app}"; Flags: ignoreversion
Source: "C:\Users\Luis Acxis\Desktop\GamersStore\removeMenuGamersLink.bat"; DestDir: "{app}"; Flags: ignoreversion
; NOTE: Don't use "Flags: ignoreversion" on any shared system files

[Icons]
Name: "{autoprograms}\{#MyAppName}"; Filename: "{app}\{#MyAppExeName}"
Name: "{autodesktop}\{#MyAppName}"; Filename: "{app}\{#MyAppExeName}"; Tasks: desktopicon
Name: "{userappdata}\Microsoft\Internet Explorer\Quick Launch\{#MyAppName}"; Filename: "{app}\{#MyAppExeName}"; Tasks: quicklaunchicon

[Run]
Filename: "{app}\{#MyAppExeName}"; Description: "{cm:LaunchProgram,{#StringChange(MyAppName, '&', '&&')}}"; Flags: nowait postinstall skipifsilent

