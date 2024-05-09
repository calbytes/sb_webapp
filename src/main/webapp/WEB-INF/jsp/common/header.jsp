<title>sb_webapp</title>

<meta name="viewport" content="width=device-width, initial-scale=1">

<div class="topnav" id="topnavid">
  <a id="hometab" href="/">Home</a>
  <!-- <a id="abouttab" href="about">About</a> -->
  <a id="projectstab" href="projects">Projects</a>
  <a id="contacttab" href="contact">Contact</a>
  <a id="logintab" href="login" class="tabright">Log-In</a>
</div>

<script>
    var headid = document.head.id;
    var tab = headid + "tab";
    document.getElementById(tab).classList.add("active");
</script>