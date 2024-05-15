<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:template match="/">
    <paises>
        <pais>
        
            <xsl:apply-templates select="//pais">
                <xsl:sort select="number(translate(crescimentoPopulacional, '%', ''))" data-type="number" order="descending"/>
            </xsl:apply-templates>
        </pais>
    </paises>
</xsl:template>

<xsl:template match="pais">
    <xsl:if test="position() &lt;= 5">
        <nome><xsl:value-of select="nome"/></nome>
    </xsl:if>
</xsl:template>

</xsl:stylesheet>
