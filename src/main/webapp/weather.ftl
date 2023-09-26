<html lang="en">
<#include "base.ftl">

<#macro title>Forecast page</#macro>
<#macro header>Forecast</#macro>

<#macro content>
    <#if forecast??>
        It's your forecast for ${forecast.cityName}
        <br>
        <strong>Temperature</strong>: ${forecast.temp}°C
        <br>
        <strong>Humidity</strong>: ${forecast.humidity}
        <br>
        <strong>Precipitation</strong>: ${forecast.precipitation}
    </#if>
    <#if !forecast??>
        <p>Can't find forecast</p>
    </#if>
</#macro>

</html>