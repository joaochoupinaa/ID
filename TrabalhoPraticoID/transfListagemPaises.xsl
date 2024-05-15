<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:output method="text" encoding="UTF-8"/>

<xsl:template match="/">
  <xsl:text>Listagem de Países:</xsl:text>
  <xsl:text>&#10;&#10;</xsl:text> 

  <xsl:for-each select="paises/pais">
    <xsl:value-of select="nome"/>
    <xsl:text>&#10;</xsl:text> 
  </xsl:for-each>
</xsl:template>

</xsl:stylesheet>
