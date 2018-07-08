const {app, BrowserWindow} = require('electron')
const url = require('url')
const path = require('path')

let win

function createWindow() {
    win = new BrowserWindow({width:800, height:600});
    win.loadURL(url.format({
        pathname: path.join(__dirname, '../public/index.html'),
        protocol: 'file',
        slashed: true
    }))
}

app.on('ready', createWindow)
