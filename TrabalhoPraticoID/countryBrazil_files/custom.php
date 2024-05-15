var _____WB$wombat$assign$function_____ = function(name) {return (self._wb_wombat && self._wb_wombat.local_init && self._wb_wombat.local_init(name)) || self[name]; };
if (!self.__WB_pmw) { self.__WB_pmw = function(obj) { this.__WB_source = obj; return this; } }
{
  let window = _____WB$wombat$assign$function_____("window");
  let self = _____WB$wombat$assign$function_____("self");
  let document = _____WB$wombat$assign$function_____("document");
  let location = _____WB$wombat$assign$function_____("location");
  let top = _____WB$wombat$assign$function_____("top");
  let parent = _____WB$wombat$assign$function_____("parent");
  let frames = _____WB$wombat$assign$function_____("frames");
  let opener = _____WB$wombat$assign$function_____("opener");


var menu;
var api;
var menu2;
var api2;
Mmenu.configs.offCanvas.page.nodetype = "div";


// used on home page
var menu_element = document.getElementById("myNav");
if(typeof(menu_element) !== 'undefined' && menu_element !== null)
{
	//alert('myNav exists');
document.addEventListener(
  "DOMContentLoaded", () => {

    menu = new Mmenu("nav#myNav", {
      // options
    }, {
      offCanvas: {
        clone: true,
        menu:
          {
            insertMethod: 'prepend',
            insertSelector: '#header-nav'
          }

      }
    });

    $('nav#mm-myNav .mm-navbar.mm-navbar_sticky').append('<a href="#leftSidebar" id="my-close-button" class="menuclose"> <img src="/uApp/uGraphics/close.png" alt=""> </a>');
    api = menu.API;
    const closebuttons = document.querySelectorAll( ".menuclose" );
	[].forEach.call(closebuttons, (btn)=>{
		btn.addEventListener(
			"click", ( evnt ) => {
				evnt.preventDefault();
				api.close();
			}
		);
	});
	
/*	
    document.querySelector( "a#my-close-button" )
                    .addEventListener(
                        "click", ( evnt ) => {
                            evnt.preventDefault();
                            api.close();
                        }
                    );
	}
*/
	
	api.bind( "close:after", function() {
		//alert('api.closeAppPanels');
		api.closeAllPanels();
	});	
  }
);
}


// used on country pages
var menu_element = document.getElementById("leftSidebar");
if(typeof(menu_element) !== 'undefined' && menu_element !== null)
{
	//alert('myNav exists');
document.addEventListener(
  "DOMContentLoaded", () => {
    grabTitle = $('nav#leftSidebar ul li').first().text();
    grabAnchor = $('nav#leftSidebar ul li a').first().attr('href');
    menu2 = new Mmenu("nav#leftSidebar", {

      navbar: {
      title: grabTitle,
      titleLink: 'anchor',

   }
    }, {
      offCanvas: {
        clone: true,
        menu:
          {
            insertMethod: 'prepend',
            insertSelector: '#header-nav'
          }

      }
    });

    $('.mm-navbar.mm-navbar_sticky').append('<a href="#leftSidebar" id="my-close-button2" class="menuclose2"> <img src="/uApp/uGraphics/close.png" alt=""> </a>');
    api2 = menu2.API;
    const closebuttons = document.querySelectorAll( ".menuclose2" );
	[].forEach.call(closebuttons, (btn)=>{
		btn.addEventListener(
			"click", ( evnt ) => {
				evnt.preventDefault();
				api2.close();
			}
		);
	});
	
/*	
    document.querySelector( "a#my-close-button2" )
                    .addEventListener(
                        "click", ( evnt ) => {
                            evnt.preventDefault();
                            api2.close();
                        }
                    );
*/					
	api2.bind( "close:after", function() {
		//alert('api2.closeAppPanels');
		api2.closeAllPanels();
	});	
	
  }
);
}

jQuery(document).ready(function(){

//alert('jquery loading');

/*	
$('.crpLeftSubs').hide();
$('a.crpLeftParent').on('click', function(e){
  e.preventDefault();
  $(this).next('.crpLeftSubs').slideToggle("slow");
});
*/


});




}
/*
     FILE ARCHIVED ON 04:41:12 Nov 16, 2023 AND RETRIEVED FROM THE
     INTERNET ARCHIVE ON 23:03:57 Apr 26, 2024.
     JAVASCRIPT APPENDED BY WAYBACK MACHINE, COPYRIGHT INTERNET ARCHIVE.

     ALL OTHER CONTENT MAY ALSO BE PROTECTED BY COPYRIGHT (17 U.S.C.
     SECTION 108(a)(3)).
*/
/*
playback timings (ms):
  captures_list: 6.431
  exclusion.robots: 0.085
  exclusion.robots.policy: 0.075
  cdx.remote: 0.059
  esindex: 0.009
  LoadShardBlock: 216.817 (3)
  PetaboxLoader3.resolve: 224.474 (4)
  PetaboxLoader3.datanode: 74.852 (5)
  load_resource: 124.008 (2)
*/