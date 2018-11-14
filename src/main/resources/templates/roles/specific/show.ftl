<div>
        <div>${i.getId()}</div>
        <#if i.getName()??>
        <div>${i.getName()}</div>
        <#else>
        <div>NULL</div>
        </#if>
        <div>
            <a href="${detailPath}/edit/${i.getId()}">Show</a>
            <a href="${detailPath}/delete/${i.getId()}">Delete</a>
        </div>
    </div>