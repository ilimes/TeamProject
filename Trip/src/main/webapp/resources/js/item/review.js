function reviewSearch(){
	var selectOption = document.getElementById('reviewSearchSelect').value;
	
	//var searchText = selectedTag.previousElementSibling.value;
	var searchText = document.getElementById('searchInput').value;
	
	if(selectOption == 'titleAndContent'){
		location.href='/item/review?menuCode=MENU_002&title=' + searchText + '&content=' + searchText;
	}
	else if(selectOption == 'title'){
		location.href='/item/review?menuCode=MENU_002&title=' + searchText;
	}
	else if(selectOption == 'content'){
		location.href='/item/review?menuCode=MENU_002&content=' + searchText;
	}
	else if(selectOption == 'writer'){
		location.href='/item/review?menuCode=MENU_002&writer=' + searchText;
	}
	
}