var express = require('express');
var app = module.exports = express();

var proxy = require('http-proxy').createProxyServer({
    host: 'http://localhost:8080',

});
app.use('/', function(req, res, next) {
    proxy.web(req, res, {
        target: 'http://localhost:8080'
    }, next);
});

app.listen(3000, function(){
    console.log('Listening!');
});