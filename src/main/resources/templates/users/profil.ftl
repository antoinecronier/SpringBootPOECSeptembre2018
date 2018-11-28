<h2>Adding of a String into the session</h2>
<p>Don't forget: <#if connection??> ${connection} </#if> </p>
<form action="/users/remember" method="GET">
    <table>
        <tr> <td>To remember:</td>
        <td><input type="text" name="connection" /></td>
        </tr>
        <tr>
        <td><input type="submit" /></td>
        </tr>
    </table>
</form>