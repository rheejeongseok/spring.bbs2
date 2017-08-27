<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>info</title>
	<link rel="stylesheet" type="text/css" href="/resources/bbs2/css/common.css">
	<link rel="stylesheet" type="text/css" href="/resources/bbs2/css/info.css">
	<script type="text/javascript" src="/resources/bbs2/js/jquery-3.2.1.min.js"></script>
	<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCPHAC2vkQYDIgH4Aw15yP01-sZlBDpHv4&callback=initMap"
    async defer></script>
	<script type="text/javascript" src="/resources/bbs2/js/common.js"></script>
	<script type="text/javascript" src="/resources/bbs2/js/info.js"></script>
	<script type="text/javascript">
		var map;
      	function initMap() {
      		var myLatLng = {lat: 35.815169, lng: 127.152182};
	        map = new google.maps.Map(document.getElementById('map'), {
	        center: myLatLng,
	        zoom: 18
	        });


	        var marker = new google.maps.Marker({
		    position: myLatLng,
		    map: map,
		    title: 'yo'
  			});

  			function zoomChange(){
  				if(map.getZoom()<3){
  					map.setZoom(3);
  				}
  			}

      	}


	</script>
</head>
<body>
	<div class="wrap">
		<div class="header"><%@ include file="guide/header.jsp" %></div>
		<div class="content">
			<div class="section1">
				<img src="/resources/bbs2/img/mainTypo01.png" alt="" class="main_tp">
				<ul>
					<li><a href="javascript:void(0)"><img src="/resources/bbs2/img/i-img02.jpg" alt=""></a></li>
				</ul>
				<div class="slider_line1"></div>
			</div>
			<div class="section2">
				<div class="subtitle">
                    <span class="text1">전주한옥숙박체험관 </span><br>
                    <h2>TRAFFIC</h2>
                </div>
				<div class="line"></div>
				<div id="map"></div>
			</div>
		</div>
		<div class="footer"><%@ include file="guide/footer.jsp" %></div>
	</div>
</body>
</html>