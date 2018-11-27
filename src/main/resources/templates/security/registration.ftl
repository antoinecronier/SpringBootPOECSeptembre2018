<form action="/registration" method="POST">
    <div>Firstname</div>
    <input type="text" name="firstname" value="">
    <div>Lastname</div>
    <input type="text" name="lastname" value="">
    <div>Email</div>
    <input type="text" name="email" value="">
    <div>Password</div>
    <input type="password" name="password" value="">
    <div>Password confirm</div>
    <input type="password" name="passwordconfirm" value="">
    <input type="hidden"
            name="${_csrf.parameterName}"
            value="${_csrf.token}"/>
    <div><input type="submit" value="Register"></div>
</form> 