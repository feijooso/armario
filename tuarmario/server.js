var express = require('express');
var mongoose = require('mongoose');
var passport = require('passport');

require('./models/user');
require('./passport')(passport);

var app = express();
var port = process.env.PORT || 8080;

mongoose.connect('mongodb://localhost:27017/TuArmario');

app.use(passport.initialize());
app.use(passport.session());
app.get('/auth/facebook', passport.authenticate('facebook'));

app.get('/', function (req, res) {
  res.sendFile(__dirname+"/index.html");
});

app.listen(port);
console.log('escuchando en el '+port);
