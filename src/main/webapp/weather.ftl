<html lang="en">
<#include "base.ftl">

<#macro title>Forecast page</#macro>
<#macro header>Forecast</#macro>

<#macro content>
    It's your forecast for ${cityName}
    <br>
    <#if temp??>
        <strong>Temperature</strong>: ${temp}°C
        <br>
        <strong>Humidity</strong>: ${humidity}
        <br>
        <strong>Precipitation</strong>: ${precipitation}
    </#if>
    <#if !temp??>
        <p>Can't find forecast for ${cityName}</p>
    </#if>
</#macro>

</html>