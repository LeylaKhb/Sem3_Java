<html lang="en">
<#include "base.ftl">

<#macro title>Weather input page</#macro>
<#macro header>Weather input page</#macro>

<#macro content>
    Hello, please enter the city name you want to get forecast for
    <br>
    <form action="city" method="post">
        CITY:
            <input type="text" name="cityName" />
            <input type="submit" value="ok" />
    </form>
</#macro>

</html>