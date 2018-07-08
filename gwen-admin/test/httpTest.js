
var fetch = require('node-fetch');
var expect = require("chai").expect;
var host = require("../src/const")

describe("Fetch Test", function(){
    describe("HTTP FETCH GET" , function(){
        fetch("https://www.baidu.com")
            .then(res => res.text())
            .then(res => console.log(res));
    });

    describe("node environment", function(){
    	console.log(process.env.NODE_ENV);
    	console.log(host);
    });

    describe("list style list", function(){
    	fetch(`${host}/style/list-all`)
    	.then(res => res.json())
    	.then(json => console.log(json));
    });
});
