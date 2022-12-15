<template>
  <div>
    <div id="meet-chefs">
				<h1>Meet the Chefs</h1>
				<div id="headshots">
					<img class="chef-hat" id="chef1" src="../assets/chef-hat.png" />
					<p class="name" id="name-k">Katy Powers</p>
					<img class="us" id="katy" src="../assets/Katy.png" />
					<img class="chef-hat" id="chef2" src="../assets/chef-hat.png" />
					<p class="name" id="name-l">Liora Lebowitz</p>
					<img class="us" id="liora" src="../assets/Liora.png" />
					<img class="chef-hat" id="chef3" src="../assets/chef-hat.png" />
					<p class="name" id="name-q">Quoc Pham</p>
					<img class="us" id="q" src="../assets/Q.png" />
					<img class="chef-hat" id="chef4" src="../assets/chef-hat.png" />
					<p class="name" id="name-z">Zac Luchette</p>
					<img class="us" id="zac" src="../assets/Zac.png" />

				</div>  
  </div>
  </div>
</template>

<script>
export default {

}
</script>

<style>
#meet-chefs{
	margin-top: 50px;
	margin-left: auto;
	margin-right: auto;
}

#meet-chefs h1{
	text-align: center;
	margin-bottom: 20px;
	font-size: 50px;
	font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;
}

#headshots{
	display: grid;
	grid-template-areas: "chef1 chef2 chef3 chef4"
						"name-k name-l name-q name-z"
						"katy liora q zac";
}
.us{
	width: 125px;
	height: auto;
	border: solid 5px #6ead42;
	border-radius: 10px;
	margin-left: auto;
	margin-right: auto;
	margin-bottom: 20px;
}
.chef-hat{
	width: auto;
	height: 70px;
	margin-left: auto;
	margin-right: auto;
}
#chef1{
	grid-area: chef1;
}
#chef2{
	grid-area: chef2;
}
#chef3{
	grid-area: chef3;
}
#chef4{
	grid-area: chef4;
}
#katy{
	grid-area: katy;
}
#name-k{
	grid-area: name-k;
}
#liora{
	grid-area: liora;
}
#name-l{
	grid-area: name-l;
}
#q{
	grid-area: q;
}
#name-q{
	grid-area: name-q;
}
#zac{
	grid-area: zac;
}
#name-z{
	grid-area: name-z;
}

.name{
	text-align: center;
	font-weight: bold;
	margin-top: 10px;
	font-size: 20px;
	font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;
}
</style>