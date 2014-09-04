<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Register Store</title>
</head>
<body>
	<!----start-header----->
	<div class="header">
	     <div class="wrap">
			<div class="top-header">
				<div class="logo">
					<a href="index.html"><img src="Images/logo.png" title="logo" /></a>
				</div>
				<div class="social-icons">
					<ul>
						<li><a href="#"><img src="Images/facebook.png" title="facebook" /></a></li>
						<li><a href="#"><img src="Images/twitter.png" title="twitter" /></a></li>
						<li><a href="#"><img src="Images/google.png" title="google pluse" /></a></li>
					</ul>
				</div>
				<div class="clear"> </div>
			</div>
			<!---start-top-nav---->
			<div class="top-nav">
				<div class="top-nav-left">
					<ul>
						<li><a href="registrarComprador.html">Home</a></li>
						<li><a href="registrarComprador.html">PROMOCIONes</a></li>
						<li><a href="registrarComprador.html">BUSQUEDA</a></li>
						<li><a href="registrarComprador.html">sERVICIOS</a></li>
						<li class="active"><a href="registrarComprador.html">rEGISTRO</a><li>
						<li><div class="clear"> </div><li>
					</ul>
             </div>
				<div class="top-nav-right">
					<div class="telephone">
                    <a href="Tel:3002345679" rel="external">
					<span><i class="phone_img"><img src="images/phone.png" alt="" /></i></span><span class="number">(300) 234-5678</span></a>
					</div>
			     </div>
				<div class="clear"> </div>
			</div>
			<!---End-top-nav---->
		</div>
	</div>
   	<!----End-header----->
	<!---start-content---->
	<form method="POST" action="registerStoreAction.html">
		<div class="contact_desc">
			<div class="wrap">
				<div class="contact-form">
					<h2>REGISTRO TIENDAS</h2>
					<div class="left_form">
						<div>
							<span><label>NOMBRE TIENDA</label></span>
						    <span><input name="name" type="text" class="textbox"></span>
						</div>
						<div>
							<span><label>NIT</label></span>
						  	<span><input name="nit" type="text" class="textbox"></span>
						</div>
					</div>
					<div class="right_form">
						<div>
  							<span class="clear">
  								<input name="Enviar" type="submit" class="myButton" value="Registrar" id="sendButton">
  							</span>
  						</div>
  					</div>
				</div>
	         	<p>&nbsp;</p>
	          	<p>&nbsp;</p>
			   	<div class="content_bottom"></div>
		  	</div>
		</div>
	</form>
	<!---start-footer---->
	<div class="footer">
		<div class="wrap"> 
			<div class="footer-grid">
				<h3>Promociones </h3>
				<div class="address">
					<ul>
						<li>15% de descuento por pago con tarjeta Comfama en Santafé,</li>
						<li>25% en frutas y verduras con tu tarjeta Exito.</li>
						<li>2X1 en mimo´s con tu tarjeta VISA</li>
						<li></li>
					</ul>
			   	</div>
			</div>
			<div class="footer-grid twitts">
				<h3>ULTIMOS Tweets</h3>
				<p>
				 	<label>@Internauta:</label>
					Ha sido realmente útil ubicar lo que deseaba comprar utilizando esta aplicación. 
				</p>
				<span>Hace 10 minutos...</span>
		        <p>
		          <label>@fercho1689: De mucha ayuda SafeBuy.</label>
		        </p>
				<span>Hace 15 minutos...</span>
			</div>
			<div class="footer-grid center-grid">
			 	<h3>tips</h3>
				<ul>
					<li><a href="#">- Compra en sitios reconocidos, certificados y seguros.</a></li>
					<li><a href="#">- Utiliza los beneficios obtenidos para comprar.</a></li>
					<li></li>
				</ul>
			</div>		
			<div class="footer-grid">
				<h3>SABIAS QUE...</h3>
				<p>SafeBuy te ofrece información disponible para que aproveches las ofertas y oportunidades comerciales que te ayudarán a ahorrar dinero en tus compras.</p>
			</div>
			<div class="clear"> </div>
		</div>
	</div>
	<div class="copy-right">
		<p>Design by <a href="http://w3layouts.com/"> W3layouts</a></p>
	</div>
	<!---End-footer---->
</body>
</html>
