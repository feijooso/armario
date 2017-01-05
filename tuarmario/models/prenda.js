var mongoose = require ('mongoose');

module.exports = mongoose.model('prenda',{
	tipo: String,
	color: String,
	talle: String,
	marca: String,
	cantidad: Number,
	imagen: String
})