<template>
    <div>
        <div id="map" style="width: 100%; height: 400px; margin: auto;"></div>
    </div>
</template>

<script>
import { mapGetters } from 'vuex';
export default {
    data(){
        return{
            markers : [],
            map : null,
            selectedMarker : null,
            selectedInfo : null,
        }
    },
    computed: {
        ...mapGetters(['apt','apts','parkings']),
    },
    mounted() { 
        window.kakao && window.kakao.maps ? this.initMap() : this.addScript(); 
    }, 
    
    methods : { 
        initMap() {
            var container = document.getElementById('map');
            var options = { 
                center: new kakao.maps.LatLng(33.450701, 126.570667),
                level: 3 
            }; 
            
            this.map = new kakao.maps.Map(container, options); 
            // var marker = new kakao.maps.Marker({ position: map.getCenter() }); 
            // marker.setMap(map);
            
        }, 
        
        addScript() { 
            const script = document.createElement('script');
            script.onload = () => kakao.maps.load(this.initMap); 
            
            script.src = 'http://dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=fcc74214195e2252bee9f95ffa0b4982'; 
            document.head.appendChild(script); 
        },
        
        addMarker(datas){
            this.deleteMarkers()

            if(!datas) return;
            var imageSrc = require('@/assets/markers.png'),
            imageSize = new kakao.maps.Size(30, 40), // 마커이미지의 크기입니다
            imageOption = { offset: new kakao.maps.Point(30, 40) }; // 마커이미지의 옵션입니다. 마커의 좌표와 일치시킬 이미지 안에서의 좌표를 설정합니다.

// 마커의 이미지정보를 가지고 있는 마커이미지를 생성합니다
            var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize, imageOption);
            datas.forEach(pos=> {
                var marker = new kakao.maps.Marker({
                    clickable:true,
                    position: new kakao.maps.LatLng(parseFloat(pos.lat), parseFloat(pos.lng)),
                    image: markerImage,

                });
                
                marker.setMap(this.map);
                this.markers.push(marker);

                var iwContent =`<center>[${pos.aptName}] <br> 거래가 : ${pos.dealAmount}<br><a href="https://map.kakao.com/link/to/Hello World!,33.450701,126.570667" style="color:blue" target="_blank">길찾기</a></center>`;
                 

                var infowindow = new kakao.maps.InfoWindow({
                    content : iwContent,
                    removable : true,
                });

                kakao.maps.event.addListener(marker, 'mouseover', ()=> {
                    infowindow.open(this.map, marker);
                });

                // 마커에 마우스아웃 이벤트를 등록합니다
                kakao.maps.event.addListener(marker, 'mouseout',() => {
                    infowindow.close();
                });
                // // 마커에 클릭이벤트를 등록합니다
                // kakao.maps.event.addListener(marker, 'click', function() {
                //     // click 했을때 이벤트  
                //     infowindow.open(this.map, marker); 
                // });
                
                this.map.setCenter(marker.getPosition());
            })
        },

        addMarkerPark(datas){
            this.deleteMarkers()

            if(!datas) return;
            var imageSrc = require('@/assets/parkmarker.png'),
            imageSize = new kakao.maps.Size(30, 40), // 마커이미지의 크기입니다
            imageOption = { offset: new kakao.maps.Point(30, 40) }; // 마커이미지의 옵션입니다. 마커의 좌표와 일치시킬 이미지 안에서의 좌표를 설정합니다.

// 마커의 이미지정보를 가지고 있는 마커이미지를 생성합니다
            var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize, imageOption);
            datas.forEach(pos=> {
                var marker = new kakao.maps.Marker({
                    clickable:true,
                    position: new kakao.maps.LatLng(parseFloat(pos.lat), parseFloat(pos.lng)),
                    image: markerImage,

                });
                
                marker.setMap(this.map);
                this.markers.push(marker);

                var iwContent =`<center>[${pos.parking_name}] <br> ${pos.addr} <br> ${pos.operation_rule_nm} <br> tel : ${pos.tel}</center>`;              

                var infowindow = new kakao.maps.InfoWindow({
                    content : iwContent,
                    removable : true,
                });

                // kakao.maps.event.addListener(marker, 'mouseover', ()=> {
                //     infowindow.open(this.map, marker);
                // });

                // kakao.maps.event.addListener(marker, 'mouseout',() => {
                //     infowindow.close();
                // });
                
                kakao.maps.event.addListener(marker, 'click', ()=> {
                    console.log(this.selectedMarker)
                    if (!this.selectedInfo||
                        !this.selectedMarker || this.selectedMarker !== marker) {
                        !!this.selectedInfo && this.selectedInfo.close();

                        infowindow.open(this.map, marker);
                    }
                    this.selectedInfo = infowindow;
                    this.selectedMarker = marker;
                });
                
                this.map.setCenter(marker.getPosition());
            })
        },

        movemap(pos){
            var coords = new kakao.maps.LatLng(parseFloat(pos.lat), parseFloat(pos.lng))
            this.map.setCenter(coords);
        },

        deleteMarkers() {
          this.clearMarkers();
          this.markers = [];
          
        },

        clearMarkers() {
            this.setMapOnAll(null);
        },

        setMapOnAll(map) {
            for (let i = 0; i < this.markers.length; i++) {
                this.markers[i].setMap(map);
            }
        },
    },
    watch:{
        apt : function(newVal, oldVal){
            this.movemap(newVal);
            oldVal
        },
        apts : function(newVal, oldVal){
            this.addMarker(newVal);
            oldVal
        },
        parkings : function(newVal, oldVal){
            this.addMarkerPark(newVal);
            oldVal
        }
    }
}   

</script>

<style>

</style>