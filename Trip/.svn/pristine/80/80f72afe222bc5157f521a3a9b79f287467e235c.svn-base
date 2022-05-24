//상품등록 JS
function regItem(){
	

	
	var selectBox = document.getElementById('categorySelector').value;

	//패키지명 미기입 시 alert
	var bookName = document.getElementById('itemName').value;
	var startDate = document.getElementById('startDate').value;
	var endDate = document.getElementById('endDate').value;
	
	if(bookName == ''){
		alert('패키지명은 필수입력입니다.');
		return ;
	}
	
	//가격 미기입 시 alert
	var bookPrice = document.getElementById('itemPrice').value;
	
	if(bookPrice == ''){
		alert('가격은 필수입력입니다.');
		return ;
	}
	
	//카테고리 미선택 시 alert
	if(selectBox == 1){
		alert('카테고리를 선택해주세요');
		return ;
	}
	
	if(startDate > endDate){
		alert('여행 종료일이 여행 시작일보다 빠릅니다.');
		return ;
	}
	
	 
	
	//폼태그 submit
	var regItem = document.getElementById('itemRegForm');
	alert('등록 완료');
	regItem.submit();
	
}


//달력 스타일 datepicker
$.datepicker.setDefaults({
  dateFormat: 'yy-mm-dd',
  prevText: '이전 달',
  nextText: '다음 달',
  monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
  monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
  dayNames: ['일', '월', '화', '수', '목', '금', '토'],
  dayNamesShort: ['일', '월', '화', '수', '목', '금', '토'],
  dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'],
  showMonthAfterYear: true,
  yearSuffix: '년'
});

//출발일, 도착일 이전날짜 비활성화
$(function() {
        $("#startDate").datepicker({
            minDate: 0
        });                           
});
$(function() {
        $("#endDate").datepicker({
            minDate: 1
            
        });                           
});


//-----------------------카카오맵 지도---------------------//
var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = { 
        center: new kakao.maps.LatLng(35.53500422503438, 129.31028385893904), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };

//지도를 생성합니다    
		var map = new daum.maps.Map(mapContainer, mapOption); 

		//주소-좌표 변환 객체를 생성합니다
		var geocoder = new daum.maps.services.Geocoder();

		var markerPosition  = new kakao.maps.LatLng(35.53500422503438, 129.31028385893904); 
		var marker = new daum.maps.Marker(); // 클릭한 위치를 표시할 마커입니다
		
		
		marker.setPosition(markerPosition);
		marker.setMap(map);

		var lat = document.getElementById('latitude');
		var lon = document.getElementById('longitude');
		var addr = document.getElementById('keyword')
		
		//지도를 클릭했을 때 클릭 위치 좌표에 대한 주소정보를 표시하도록 이벤트를 등록합니다
		daum.maps.event.addListener(map, 'click', function(mouseEvent) {
		searchDetailAddrFromCoords(mouseEvent.latLng, function(result, status) {
    		if (status === daum.maps.services.Status.OK) {
        			var detailAddr = !!result[0].road_address ? '<div>도로명주소 : ' + result[0].road_address.address_name + '</div>' : '';
       			 		
       			 		if(detailAddr == null || detailAddr == ''){
	
       			 		detailAddr += '<div>지번 주소 : ' + result[0].address.address_name + '</div>';
						}
        
        			var content = '<div class="bAddr">' + detailAddr + '</div>';
                    
                    
                    addr.value = !!result[0].road_address ? result[0].road_address.address_name : '';
                  
	                    if (addr.value == null || addr.value == ''){
						
						addr.value = result[0].address.address_name;
						
						}

        			// 마커를 클릭한 위치에 표시합니다 
        			marker.setPosition(mouseEvent.latLng);
       				marker.setMap(map);
					
        			// 인포윈도우에 클릭한 위치에 대한 상세 주소정보를 표시합니다
        			infowindow.setContent(content);
        			infowindow.open(map, marker);
        			
        			var latlng = mouseEvent.latLng;
        			
        			lat.innerHTML = latlng.getLng();
        			lon.innerHTML = latlng.getLat();
        			
        			//alert("test.... : "  + latlng.getLat()  + ",  " + latlng.getLng()) ;         
        			$('input:hidden[name="longitude"]').val(latlng.getLng());
        			$('input:hidden[name="latitude"]').val(latlng.getLat());
        			
        			
        			
        			
    			}   
			});
		});
	

	function searchAddrFromCoords(coords, callback) {
	// 좌표로 주소 정보를 요청합니다
	geocoder.coord2RegionCode(coords.getLng(), coords.getLat(), callback);         
	}

	function searchDetailAddrFromCoords(coords, callback) {
	// 좌표로 상세 주소 정보를 요청합니다
	geocoder.coord2Address(coords.getLng(), coords.getLat(), callback);
	}

	//지도 좌측상단에 지도 중심좌표에 대한 주소정보를 표출하는 함수입니다
	function displayCenterInfo(result, status) {
	if (status === daum.maps.services.Status.OK) {
    	var infoDiv = document.getElementById('centerAddr');

   			 for(var i = 0; i < result.length; i++) {
        			if (result[i].region_type === 'H') {
            			infoDiv.innerHTML = result[i].address_name;
            		break;
        			}
    		}
		}    
	}
	
	
// 검색 결과 목록이나 마커를 클릭했을 때 장소명을 표출할 인포윈도우를 생성합니다
var infowindow = new kakao.maps.InfoWindow({zIndex:1});

// 키워드로 장소를 검색합니다
var ps = new kakao.maps.services.Places(); 

// 키워드 검색을 요청하는 함수입니다
function searchPlaces() {

    var keyword = document.getElementById('keyword').value;

    if (!keyword.replace(/^\s+|\s+$/g, '')) {
        alert('장소를 입력해주세요!');
        return false;
    }

    // 장소검색 객체를 통해 키워드로 장소검색을 요청합니다
    ps.keywordSearch( keyword, placesSearchCB); 
}



// 키워드 검색 완료 시 호출되는 콜백함수 입니다
function placesSearchCB (data, status, pagination) {
    if (status === kakao.maps.services.Status.OK) {

        // 검색된 장소 위치를 기준으로 지도 범위를 재설정하기위해
        // LatLngBounds 객체에 좌표를 추가합니다
        var bounds = new kakao.maps.LatLngBounds();

        for (var i=0; i<data.length; i++) {
            displayMarker(data[i]);    
            bounds.extend(new kakao.maps.LatLng(data[i].y, data[i].x));
        }       

        // 검색된 장소 위치를 기준으로 지도 범위를 재설정합니다
        map.setBounds(bounds);
    } 
}

// 지도에 마커를 표시하는 함수입니다
function displayMarker(place) {
    
    // 마커를 생성하고 지도에 표시합니다
    var marker = new kakao.maps.Marker({
        map: map,
        position: new kakao.maps.LatLng(place.y, place.x) 
    });

    // 마커에 클릭이벤트를 등록합니다
    kakao.maps.event.addListener(marker, 'click', function() {
        // 마커를 클릭하면 장소명이 인포윈도우에 표출됩니다
        infowindow.setContent('<div style="padding:5px;font-size:12px;">' + place.place_name + '</div>');
        infowindow.open(map, marker);
    });
}

