var Prenda = require('./app/models/prenda');
var Controller = require('./app/controllers/controller_prenda');

module.exports = function(app){
	app.get('/api/prenda', Controller.getPrenda);
	app.post('/api/prenda', Controller.setPrenda);
	app.delete('/api/prenda/:prenda_id', Controller.removePrenda);
	app.get('*', function(req, res) {
		res.sendfile('./angular/index.html'); 
	});
};