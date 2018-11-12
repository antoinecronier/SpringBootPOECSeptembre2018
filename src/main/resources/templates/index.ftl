<#import "/spring.ftl" as spring/>

<link rel="stylesheet" type="text/css" 
    href="<@spring.url '/css/bootstrap.css'/>"/>
<script src="<@spring.url '/javascript/bootstrap.js'/>"></script>

 <link rel="stylesheet" type="text/css" 
    href="<@spring.url '/css/default.css'/>"/>
     
<h1>Coucou</h1>
<p>Hello</p>
aizjejoiajzeoijaziejoiazjeoijaoziejzajie
<button type="button" class="btn btn-warning">Warning</button>

<div>${att1}</div>

<div>${user}</div>
<div>${user.getFirstname()}</div>
<div>${user.getLastname()}</div>

<#assign a = 1>
<#if users??>

<#list users as u>
<#if u.getLastname() = "u1">
<div>coucou</div>
</#if>
<div> ${a}
	<div>${u.getFirstname()}</div>
	<div>${u.getLastname()}</div>
</div>
<#assign a++>
</#list>

</#if>

<form action="/save1" method="POST">
  First name:<br>
  <input type="text" name="firstname" value="Mickey">
  <br>
  Last name:<br>
  <input type="text" name="lastname" value="Mouse">
  <br><br>
  <input type="submit" value="Submit">
</form> 
