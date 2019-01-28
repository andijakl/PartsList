Write-Host @"
To start the local mock server required for the app:"
1. Install node.js
2. Global install of json-server:
   npm install -g json-server
3. Start server
   For localhost (emulator): 
   json-server --watch db.json
   
   For accessing from your phone in the same network:
   json-server --watch db.json --host <yourIp>
"@

json-server --watch db.json
