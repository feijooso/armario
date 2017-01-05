var Prenda = require('./app/models/prenda');

exports.getPrenda = function (req, res){
	Prenda.find(
		function(err, prenda) {
			if (err)
				res.send(err)
			res.json(prenda);
		}
		);
}

exports.setPrenda = function(req, res) {
	Prenda.create(
		{tipo : req.body.tipo, color: req.body.color, talle: req.body.talle, marca: req.body.marca, cantidad: req.body.cantidad, imagen: req.body.imagen}
		function(err, persona) {
			if(err)
				res.send(err);
			Prenda.find(function(err,persona){
				if(err)
					res.send(err)
				res.json(prenda);
			});
		});
}

exports.removePrenda = function(req,res) {
	Prenda.remove({_id : req.params.prenda_id}, function(err, prenda){
		if(err)
			res.send(err);
		Prenda.find(function(err,persona){
			if (err)
				res.send(err)
			res.json(persona);
		});
	});
}