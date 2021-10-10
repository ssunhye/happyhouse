<template>
    <div id="footer">
        <b-container id="container" class="p-4">
            <div class="row">
                <h3>Happy House</h3>
            </div>
            <div class="row p-3 mb-3">
                <div class="col-sm-3">
                    <h4>[ Service ]</h4>
                    <ul>
                        <ol>매매 검색</ol>
                        <ol>관심 지역 등록</ol>
                    </ul>
                </div>
                <div class="col-sm-3">
                    <h4>[ House ]</h4>
                    <ul>
                        <ol>공지사항</ol>
                        <ol>Q & A</ol>
                    </ul>
                </div>
                <div class="col-sm-3">
                    <h4>[ Policies ]</h4>
                    <ul>
                        <ol>Terms of Use</ol>
                    </ul>
                </div>
                <div class="col-sm-3">
                    <h4>[ About House ]</h4>
                    <ul>
                        <ol>Company Information</ol>
                        <ol>Careers</ol>
                        <ol>Copyright</ol>
                    </ul>
                </div>
            </div>
            
            <div id="copyright">
                <p>Copyright © 2021 Happy house. All rights reserved. Designed by 선혜 규영</p>
            </div>
        </b-container>
    </div>
</template>
<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Montserrat&display=swap');
  p {
    font-size: 13px;
    font-family: 'Montserrat', sans-serif;
    color: wheat;
  }
  #footer {
    background-color: #343A40;
    border-top:5px solid rgb(107, 100, 103);
    border-bottom:5px solid rgb(107, 100, 103);
  }
  h3 {
      color: #c1c7ce
  }
  h4{
      color: #a4b3c4
  }
  #copyright {
      text-align: right;
  }
  ol, ul {
      color: #a4b3c4;
      margin:0;
      padding:0;
  }
</style>
<script>
export default {}
</script>